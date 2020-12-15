package mef.richieste.beni.facili.consumo.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

public class UtenteUtil {

	public List<User> findUser(String cognome, String nome){
	
		DynamicQuery queryUtenti = DynamicQueryFactoryUtil.forClass(User.class);
	 
			if(cognome!=null){
						//Property propertyCognome=PropertyFactoryUtil.forName("lastName");
				queryUtenti.add(RestrictionsFactoryUtil.ilike("lastName",cognome));
						}
			if(nome!=null){
						//Property propertyNome=PropertyFactoryUtil.forName("firstName");
				queryUtenti.add(RestrictionsFactoryUtil.ilike("firstName",nome));
						}
			Projection prjectionEmail=ProjectionFactoryUtil.property("emailAddress");
			queryUtenti.setProjection(prjectionEmail); 
			 
			List<User> res_utenti = UserLocalServiceUtil.dynamicQuery(queryUtenti);
			
		return res_utenti;	
	}

}
