package mef.organigramma.util;
import com.intranet.mef.job.siap.model.OrganizationChart;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

import com.intranet.mef.job.siap.service.OrganizationChartLocalServiceUtil;
import java.util.ArrayList;
import java.util.List;
public class QueryUtil {

	
	public List<OrganizationChart> findOrganigrammaFromParent(long idPadre ){	
		DynamicQuery queryOrg = OrganizationChartLocalServiceUtil.dynamicQuery();
		queryOrg.add(PropertyFactoryUtil.forName("idParent").eq(idPadre));
		List<OrganizationChart> organizations=OrganizationChartLocalServiceUtil.dynamicQuery(queryOrg);
		return organizations;
	}
}
