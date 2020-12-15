package it.accenture.twitter.model;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JsonTweet implements Serializable {

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

    public static String parseTwitterDate(String dataTweet){
        Locale.setDefault(Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        String dataTweetText = "";
        Date tweetDate = null;
        try {
            tweetDate = sdf.parse(dataTweet);
        } catch (ParseException e) {
        	_log.error("Error "+e.getMessage());
        }
        Date actualDate = new Date();
        
        if(tweetDate != null) {
            double diff = Math.floor((actualDate.getTime() - tweetDate.getTime()) / 1000d);
                        
            if (diff <= 90) {
                dataTweetText = "adesso";
            } else if (diff <= 3540) {
                dataTweetText = Math.round(diff / 60l) + " minuti fa";
            } else if (diff <= 5400) {
                dataTweetText = "1 ora fa";
            } else if (diff <= 86400) {
                dataTweetText = Math.round(diff / 3600l) + " ore fa";
            } else if (diff <= 129600) {
                dataTweetText = "1 giorno fa";
            } else if (diff > 129600) {
                Locale.setDefault(Locale.ITALIAN);
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd MMM");
                dataTweetText = sdf2.format(tweetDate);
            }
        }
        return dataTweetText;
    }

    private static Log _log = LogFactoryUtil.getLog(JsonTweet.class.getName());
}
