package it.accenture.radiocor.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JsonRadiocor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JSONArray jsonArray;

	private Integer timestamp;

    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public static String parseRadiocorDate(String dataRadiocor){
        Locale.setDefault(Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd hh:mm:ss +ms yyyy");
        String dataRadiocorText = "";
        Date radiocorDate = null;
        try {
        	radiocorDate = sdf.parse(dataRadiocor);
        } catch (ParseException e) {
        	_log.error("Error "+e.getMessage());
        }
        Date actualDate = new Date();
        if(radiocorDate != null) {
            double diff = Math.floor((actualDate.getTime() - radiocorDate.getTime()) / 1000d);

            if (diff <= 90) {
            	dataRadiocorText = "adesso";
            } else if (diff <= 3540) {
            	dataRadiocorText = Math.round(diff / 60l) + " minuti fa";
            } else if (diff <= 5400) {
            	dataRadiocorText = "1 ora fa";
            } else if (diff <= 86400) {
            	dataRadiocorText = Math.round(diff / 3600l) + " ore fa";
            } else if (diff <= 129600) {
            	dataRadiocorText = "1 giorno fa";
            } else if (diff > 129600) {
                Locale.setDefault(Locale.ITALIAN);
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM");
                dataRadiocorText = sdf2.format(radiocorDate);
            }
        }
        return dataRadiocorText;
    }

    private static Log _log = LogFactoryUtil.getLog(JsonRadiocor.class.getName());
}
