/**
 * Unpublished Copyright SMC TREVISO SRL. All rights reserved.
 *
 * The contents of this file are subject to the terms of the SMC TREVISO's
 * "CONDIZIONI GENERALI DI LICENZA D'USO DI SOFTWARE APPLICATIVO STANDARD SMC"
 * ("License"). You may not use this file except in compliance with the License.
 * You can obtain a copy of the License by contacting SMC TREVISO. See the
 * License for the limitations under the License, including but not limited to
 * distribution rights of the Software. You may not - for example - copy,
 * modify, transfer, transmit or distribute the whole file or portion of it, or
 * derived works, to a third party, except as may be permitted by SMC in a
 * written agreement.
 * To the maximum extent permitted by applicable law, this file is provided
 * "as is" without warranty of any kind, either expressed or implied, including
 * but not limited to, the implied warranty of merchantability, non infringement
 * and fitness for a particular purpose. SMC does not guarantee that the use of
 * the file will not be interrupted or error free.
 */

package com.intranet.mef.job.siap.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author SMC Treviso
 */
public class IntranetMefSiapDbConfigurationValues {

	public static final String FUNCTION_DB_SIAP_ORACLE_DUMMY =
		GetterUtil.getString(
			IntranetMefSiapDbConfigurationUtil.get(
				IntranetMefSiapDbConfigurationKeys.FUNCTION_DB_SIAP_ORACLE_DUMMY));
 
	public static final String FUNCTION_DB_SIAP_ORACLE_LOAD_BCK =
		GetterUtil.getString(
			IntranetMefSiapDbConfigurationUtil.get(
				IntranetMefSiapDbConfigurationKeys.FUNCTION_DB_SIAP_ORACLE_LOAD_BCK));

	public static final String FUNCTION_DB_SIAP_ORACLE_LOAD_ERROR_IMPORT =
		GetterUtil.getString(
			IntranetMefSiapDbConfigurationUtil.get(
				IntranetMefSiapDbConfigurationKeys.FUNCTION_DB_SIAP_ORACLE_LOAD_ERROR_IMPORT));

}