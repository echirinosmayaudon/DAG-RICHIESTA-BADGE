/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package service.intranet.mef.model.impl;

import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.StringBundler;

import java.text.SimpleDateFormat;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the RichiestaBeneInv service. Represents a row in the &quot;MFORM_RichiestaBeneInv&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link service.intranet.mef.model.RichiestaBeneInv} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType

public class RichiestaBeneInvImpl extends RichiestaBeneInvBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a richiesta bene inv model instance should use the {@link service.intranet.mef.model.RichiestaBeneInv} interface instead.
	 */
	public RichiestaBeneInvImpl() {
	}
	        @Override
		   	public String toString() {
			 StringBundler sb = new StringBundler();
			 
			 sb.append("{\"id_richiesta\":");
			 sb.append("\"");
			 sb.append(getId_richiesta());
			 sb.append("\"");
			 sb.append(",\"utente\":");
			 sb.append("\"");
			 sb.append(getUtente());
			 sb.append("\"");
			 sb.append(",\"nome_rich\":");
			 sb.append("\"");
			 sb.append(getNome_rich());
			 sb.append("\"");
			 sb.append(",\"cogn_rich\":");
			 sb.append("\"");
			 sb.append(getCogn_rich());
			 sb.append("\"");
			 sb.append(",\"dip_dir\":");
			 sb.append("\"");
			 sb.append(getDip_dir());
			 sb.append("\"");
			 sb.append(",\"dati_rich\":");
//			 sb.append(""\");
			 sb.append(getDati_rich());
//			 sb.append("\"");
			 sb.append(",\"oggetto\":");
			 sb.append("\"");
			 sb.append(getOggetto());
			 sb.append("\"");
			 sb.append(",\"data\":");
			 sb.append("\"");
			 
			 SimpleDateFormat sfdDate =new SimpleDateFormat("dd.MM.yyyy");
			 
			 
			 sb.append(sfdDate.format(getData()));
			 sb.append("\"");
			 sb.append(",\"beneficiario\":");
//			 sb.append("\"");
			 sb.append(getBeneficiario());
//			 sb.append("\"");
			 sb.append(",\"destinazione\":");
			 sb.append("\"");
			 sb.append(getDestinazione());
			 sb.append("\"");
			 sb.append(",\"id_stato\":");
			 sb.append("\"");
			 sb.append(getId_stato());
			 sb.append("\"");
			 sb.append(",\"note_consegn\":");
			 sb.append("\"");
			 sb.append(getNote_consegn());
			 sb.append("\"");
			 sb.append("}");

			 return sb.toString();
	 }
	
}