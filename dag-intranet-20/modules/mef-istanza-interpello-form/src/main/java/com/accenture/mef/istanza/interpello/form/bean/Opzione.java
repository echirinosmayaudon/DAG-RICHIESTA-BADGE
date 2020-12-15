package com.accenture.mef.istanza.interpello.form.bean;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class Opzione {

	private Long id;
	private String testoOpzione;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTestoOpzione() {
		return testoOpzione;
	}

	public void setTestoOpzione(String testoOpzione) {
		this.testoOpzione = testoOpzione;
	}

	public String toJSON() {

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("id", this.getId());
		json.put("testoOpzione", this.getTestoOpzione());

		return json.toJSONString();
	}

}