<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="it.accenture.forecast.model.Currently"%>
<%@ page import="it.accenture.forecast.model.Datum__"%>
<%@ page import="it.accenture.forecast.util.ConversionsUtil"%>
<%@ page import="java.util.*"%>
<%@ include file="init.jsp"%>

<%
	DarkSky darkSky = (DarkSky) renderRequest.getAttribute("darkSky");
	Map<String, Object> contextObjects = new HashMap<>();
	contextObjects.put("darkSky", darkSky);
	contextObjects.put("conversionsUtil", ConversionsUtil.getConversionsUtil());
	contextObjects.put("weatherPortletInstanceConfiguration", weatherPortletInstanceConfiguration);

	Currently currently = darkSky.getCurrently();
	List<Datum__> dataDaily = darkSky.getDaily().getData();
	int temperatureAcDay = 0;
	if ("celsius".equals(weatherPortletInstanceConfiguration.degreesUnits()))
		temperatureAcDay = (int) ConversionsUtil
				.round(ConversionsUtil.fahrenheitToCelsius(currently.getTemperature()), 0);
	else
		temperatureAcDay = (int) ConversionsUtil.round(currently.getTemperature(), 0);
%>

<liferay-ddm:template-renderer
	className="<%=DarkSky.class.getName()%>"
	contextObjects="<%=contextObjects%>"
	displayStyle="<%=displayStyle%>"
	displayStyleGroupId="<%=displayStyleGroupId%>"
	entries="<%=emptyDarkSkyList%>">
		<div class="wrapper-title-white">
			<h2 class="title-box-white borders-white">
				METEO <span class="title-box meteo-city"><%=weatherPortletInstanceConfiguration.location()%></span>
				<span class="meteo-hour copy-text pull-right"><span
					class="icomoon-time"></span><%=ConversionsUtil.getHourDay(((new Date()).getTime() / 1000), locale, timeZone.getID(), darkSky.getOffset())%></span>
			</h2>
			<h4 class="copy-text text-right">
				<liferay-ui:message key="<%=currently.getIcon()%>"></liferay-ui:message>
			</h4>
		</div>
		<div class="meteo-item">
			<div class="today-meteo">
				<canvas id="<portlet:namespace/>iconNow" width="150" height="73"></canvas>
				<span class="celsius-degrees"><%=temperatureAcDay%>°</span>
			</div>
			<div class="info-meteo-today">
				<div class="meteo-today-item">
					<svg xmlns="http://www.w3.org/2000/svg" width="31" height="28" viewBox="0 0 31 28">
								<path fill="#EBC028" fill-rule="evenodd" d="M22.472 5.563c2.964 1.837 5.09 4.752 5.727 8.13-.756-.393-1.56-.568-2.412-.568-1.325 0-2.603.482-3.549 1.313-.946-.831-2.224-1.313-3.549-1.313-1.324 0-2.602.482-3.548 1.313-.947-.831-2.224-1.313-3.549-1.313-1.325 0-2.602.482-3.548 1.313-.947-.831-2.224-1.313-3.55-1.313-.85 0-1.655.175-2.412.569C3.17 7.919 8.612 3.5 15.14 3.5a14.1 14.1 0 0 1 4.273.658.97.97 0 0 0 1.106-.385c.301-.472.064-1.09-.497-1.266a16.085 16.085 0 0 0-3.936-.713V.928a.932.932 0 0 0-.784-.916c-.591-.091-1.109.333-1.109.863v.919C6.293 2.231 0 8.313 0 15.75c0 .307.19.569.426.744h.047c.047.043.095.043.19.088.047 0 .047 0 .094.043h.237a.72.72 0 0 0 .33-.088c.048 0 .095-.043.143-.087a.548.548 0 0 0 .236-.219 3.614 3.614 0 0 1 2.792-1.356c1.088 0 2.13.525 2.744 1.356l.284.263c.426.262 1.041.175 1.325-.219.615-.875 1.656-1.356 2.744-1.356 1.041 0 1.987.437 2.602 1.18v9.202c0 1.273.947 2.418 2.299 2.652 1.767.306 3.328-.93 3.378-2.5a.91.91 0 0 0-.708-.926c-.616-.14-1.172.287-1.183.832a.925.925 0 0 1-.795.88c-.587.086-1.098-.336-1.098-.864v-9.318c.615-.744 1.561-1.182 2.602-1.182 1.089 0 2.13.525 2.745 1.356l.284.263s.047 0 .047.043c.047 0 .094.045.142.045a.931.931 0 0 0 .331.087c.283 0 .615-.132.804-.394.615-.875 1.656-1.356 2.745-1.356 1.088 0 2.129.525 2.744 1.356.047.044.094.132.141.175.19.087.427.175.663.175.52 0 .946-.394.946-.875 0-4.859-2.686-9.14-6.752-11.645-.425-.262-.999-.167-1.3.215-.316.403-.204.966.243 1.243"/>
							</svg>  <span
						class="copy-text-small"><%=(int) ConversionsUtil.round((currently.getPrecipProbability() * 100), 0)%>%</span>
				</div>
				<div class="meteo-today-item">
					<svg xmlns="http://www.w3.org/2000/svg" width="20" height="28" viewBox="0 0 20 28">
								<path fill="#EBC028" fill-rule="evenodd" d="M19.082 17.66a.884.884 0 0 1-.905-.71 8.146 8.146 0 0 0-.263-1.025C16.42 11.069 11.849 5.031 10.077 2.8c-1.773 2.231-6.345 8.269-7.791 13.038a7.127 7.127 0 0 0-.42 1.924c0 .219-.047.438-.047.613 0 4.375 3.686 7.918 8.258 7.918 3.925 0 7.196-2.611 8.043-6.119.115-.474.62-.767 1.116-.628l.022.006c.461.13.74.569.633 1.004C18.851 24.808 14.842 28 10.077 28 4.525 28 0 23.668 0 18.375c0-.219 0-.481.047-.744.046-.787.233-1.575.466-2.275C2.38 9.1 9.05 1.18 9.33.875L10.077 0l.7.831c.28.35 6.95 8.269 8.863 14.525.139.415.26.861.346 1.32.095.502-.309.967-.852.982l-.052.001z"/>
							</svg>  <span
						class="copy-text-small"><%=(int) ConversionsUtil.round((currently.getHumidity() * 100), 0)%>%</span>
				</div>
				<div class="meteo-today-item">
					<svg xmlns="http://www.w3.org/2000/svg" width="36" height="29" viewBox="0 0 36 29">
								<g fill="#EBC028" fill-rule="evenodd">
									<path d="M14.167 13.624c-.552 0-.999-.404-.999-.903s.447-.902.999-.902h14.786c2.75 0 4.99-2.045 4.99-4.558 0-2.515-2.24-4.56-4.99-4.56-.552 0-.998-.403-.998-.902 0-.498.446-.902.998-.902 3.852 0 6.986 2.854 6.986 6.364 0 3.509-3.134 6.363-6.986 6.363H14.167zM1.668 17.417c-.55 0-.996-.273-.996-.608 0-.336.446-.608.996-.608h26.264c.55 0 .996.272.996.608 0 .335-.446.608-.996.608H1.668zM27.244 27.996c0-.497.442-.9.987-.9 1.66 0 2.958-1.166 2.958-2.654 0-1.49-1.299-2.655-2.958-2.655H8.6c-.545 0-.986-.403-.986-.9s.441-.9.986-.9h19.63c2.718 0 4.93 1.998 4.93 4.455 0 2.456-2.212 4.455-4.93 4.455-.545 0-.987-.403-.987-.9z"/>
								</g>
							</svg>  <span
						class="copy-text-small"> <%
 	if ("kilometers".equals(weatherPortletInstanceConfiguration.windUnits()))
 			out.write(
 					(int) ConversionsUtil.round(ConversionsUtil.milesToKilometers(currently.getWindSpeed()), 0)
 							+ " km/h");
 		else if (("meters".equals(weatherPortletInstanceConfiguration.windUnits())))
 			out.write((int) ConversionsUtil
 					.round(ConversionsUtil.milesPerHourToMeterPerSecond(currently.getWindSpeed()), 0) + " m/s");
 		else
 			out.write((int) ConversionsUtil.round(currently.getWindSpeed(), 0) + " mph");
 %>
					</span>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="info-meteo-next-day">
				<%
					String toDay = ConversionsUtil.getDayWeekDisplayName(currently.getTime(), locale, timeZone.getID());
						String forecastDay = "";
						int count = 0;
						int temperature = 0;
				%>
				<%
					for (int i = 0; i < dataDaily.size(); i++) {
							Datum__ datum = dataDaily.get(i);
							forecastDay = ConversionsUtil.getDayWeekDisplayName(datum.getTime(), locale, timeZone.getID());
							if (!(forecastDay.equals(toDay)) && datum.getTime() > currently.getTime() && count <= 2) {
								count++;
								if ("celsius".equals(weatherPortletInstanceConfiguration.degreesUnits())) {
									temperature = (int) ConversionsUtil
											.round(ConversionsUtil.fahrenheitToCelsius(datum.getTemperatureMax()), 0);
								} else {
									temperature = (int) ConversionsUtil.round(datum.getTemperatureMax(), 0);
								}
				%>

				<div class="info-next-day-item">
					<h3 class="copy-text"><%=forecastDay.substring(0,3).toUpperCase()%></h3>
					<canvas id="<portlet:namespace/>iconDay<%=i%>" width="79"
						height="66"></canvas>
					<h4 class="typo-h4"><%=temperature%>°
					</h4>
				</div>


				<%
					}
						}
				%>

				<div class="clearfix"></div>
			</div>
		</div>



</liferay-ddm:template-renderer>

<script>
	var skycons<portlet:namespace/> = new Skycons({"color": "<%=weatherPortletInstanceConfiguration.coloricon()%>"});
	skycons<portlet:namespace/>.add("<portlet:namespace/>iconNow", Skycons.<%=currently.getIcon().toUpperCase().replaceAll("-","_")%>);
	<%
	for (int i = 0; i < dataDaily.size(); i++) {
		Datum__ datum = dataDaily.get(i);
	%>
		skycons<portlet:namespace/>.add("<portlet:namespace/>iconDay<%=i%>", Skycons.<%=datum.getIcon().toUpperCase().replaceAll("-","_")%>);
	<%	}	%>
	skycons<portlet:namespace/>.play();
</script>

<%!
	private static List<DarkSky> emptyDarkSkyList = new ArrayList<>();
%>

