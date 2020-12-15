package mef.richieste.figli.form.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

public class AllegatoDLUtil {
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	private final static String baseDirName = "Istanza per la concessione contributo figli";
	Log _log = LogFactoryUtil.getLog(this.getClass());
	
	public void setAreaTematica(ServiceContext serviceContext) {
	List<AssetCategory> asset_category_strumenti = new ArrayList<AssetCategory>(0);
	
	DynamicQuery query_asset_category_strumenti = DynamicQueryFactoryUtil.forClass(AssetCategory.class)
			.add(PropertyFactoryUtil.forName("name").eq("strumenti"));
	try {
		asset_category_strumenti = AssetCategoryLocalServiceUtil.dynamicQuery(query_asset_category_strumenti, 0, 1);
	} catch (Exception e) {
		_log.error("Errore nel recupero dell'area tematica: " + e);
	}

	if(!asset_category_strumenti.isEmpty()) {
		long[] assetCategoryIds = {asset_category_strumenti.get(0).getCategoryId()};
		serviceContext.setAssetCategoryIds(assetCategoryIds);
	}
	
	}
	
	public boolean deleteFolder(String baseDirName,  long parentFolderId, long creatUserId, ServiceContext serviceContext,ThemeDisplay themeDisplay, String folderName) {
		boolean delete = false;
	
		
		long repositoryId = serviceContext.getScopeGroupId();
		Folder folder = null;
		String pattern = "[&,\'@\\\\\\]}\\:=>/<\\[{%|+#`?\\\";~*]";
		String replacedName = baseDirName.replaceAll(pattern, "-");
		
			try {
				folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, replacedName);
				_log.debug("RECUPERO CARTELLA PADRE : " + folder.getName());
				DLFolder cartella = null;
				
				if(Validator.isNotNull(DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folder.getFolderId(), folderName))) {
				//List<DLFolder> folders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getScopeGroupId(), folder.getFolderId());
				cartella = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), folder.getFolderId(), folderName);
				_log.debug("CARTELLA RECUPERATA FIGLIA : " + cartella.getName());
				List<DLFileEntry> listaFile = DLFileEntryLocalServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), cartella.getFolderId());

				for(DLFileEntry file : listaFile) {
					DLFileEntryLocalServiceUtil.deleteDLFileEntry(file);
					_log.debug("CANCELLO IL FILE: " + file.getName());
				}
				
				_log.debug("CANCELLO CARTELLA FIGLIA " + cartella.getName());
				DLFolderLocalServiceUtil.deleteDLFolder(cartella.getFolderId());				
				}else {
					_log.debug("CARTELLA NON RECUPERATA PER L'UTENTE : " + creatUserId );
				}
				
				
				delete=true;
			} catch (Exception e) {
				_log.error("CARTELLA PRINCIPALE NON TROVATA O IMPOSSIBILE DA ELIMINARE " );
			}
		return delete;
	}
	
	
}
