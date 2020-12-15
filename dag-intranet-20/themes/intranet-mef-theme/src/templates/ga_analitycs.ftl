<#if ip != "">
    <#assign ip = ip>
<#else>
    <#assign ip = "IP Generico">
</#if>
<#if dipartimento != "">
    <#assign dipartimento = dipartimento>
<#else>
    <#assign dipartimento = "dipartimento Generico">
</#if>
<#if direzione != "">
    <#assign direzione = direzione>
<#else>
    <#assign direzione = "direzione Generico">
</#if>
<#if ufficio != "">
    <#assign ufficio = ufficio>
<#else>
    <#assign ufficio = "ufficio Generico">
</#if>
<#if posizione != "">
    <#assign posizione = posizione>
<#else>
    <#assign posizione = "posizione Generico">
</#if>
<#if sesso != "">
    <#assign sesso = sesso>
<#else>
    <#assign sesso = "sesso Generico">
</#if>
<#if indirizzo != "">
    <#assign indirizzo = indirizzo>
<#else>
    <#assign indirizzo = "indirizzo Generico">
</#if>
<#if qualifica != "">
    <#assign qualifica = qualifica>
<#else>
    <#assign qualifica = "qualifica Generico">
</#if>
<#if centralePeriferico != "">
    <#assign centralePeriferico = centralePeriferico>
<#else>
    <#assign centralePeriferico = "centralePeriferico Generico">
</#if>
<!-- ROUTEID -->
<script type="text/javascript">
    function getCookie(cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for(var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }
    var rout = getCookie("ROUTEID");
    window.ga=window.ga||function(){(ga.q=ga.q||[]).push(arguments)};ga.l=+new Date;
    ga('create', '${gaAnalitycsKey}', 'auto');
    ga('set', 'dimension1', rout,'SIP');
    ga('set', 'dimension6', '${ip?replace(".","")}','CIP');
    ga('set', 'dimension7', '${dipartimento?replace("\'"," ")}','Dipartimento');
    ga('set', 'dimension8', '${direzione?replace("\'"," ")}','Direzione');
    ga('set', 'dimension9', '${ufficio?replace("\'"," ")}','Ufficio');
    ga('set', 'dimension10', '${posizione?replace("\'"," ")}','Posizione');
    ga('set', 'dimension11', '${sesso}','Sesso');
    ga('set', 'dimension12', '${indirizzo?replace("\'"," ")}','Indirizzo');
    ga('set', 'dimension13', '${qualifica?replace("\'"," ")}','Qualifica');
    ga('set', 'dimension14', '${centralePeriferico?replace("\'"," ")}','Centrale');
    ga('set', 'forceSSL', true);
    ga('send', 'event', 'CIP', '${ip?replace(".","")}', 'CIP');
    ga('send', 'event', 'SIP', rout, rout );
    ga('send', 'event', 'Dipartimento' ,'${dipartimento?replace("\'"," ")}','${dipartimento?replace("\'"," ")}');
    ga('send', 'event', 'Direzione' ,'${direzione?replace("\'"," ")}','${direzione?replace("\'"," ")}');
    ga('send', 'event', 'Ufficio' ,'${ufficio?replace("\'"," ")}','${ufficio?replace("\'"," ")}');
    ga('send', 'pageview');

    (function() {
    var ga = document.createElement('script');     ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:'   == document.location.protocol ? 'https://ssl'   : 'http://www') + '.google-analytics.com/analytics.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
</script>