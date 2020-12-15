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

package com.mef.intranet.rubrica.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.mef.intranet.rubrica.service.SearchDataServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link SearchDataServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchDataServiceSoap
 * @see HttpPrincipal
 * @see SearchDataServiceUtil
 * @generated
 */
@ProviderType
public class SearchDataServiceHttp {
	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> getListCognomi(
		HttpPrincipal httpPrincipal, java.lang.String keyword)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getListCognomi", _getListCognomiParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, keyword);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<java.lang.String> getAlfabetoTag(
		HttpPrincipal httpPrincipal) throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getAlfabetoTag", _getAlfabetoTagParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<java.lang.String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastName(
		HttpPrincipal httpPrincipal, java.lang.String firstName,
		java.lang.String lastName) throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"suggestLastName", _suggestLastNameParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					firstName, lastName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVO> getListStruttureInterne(
		HttpPrincipal httpPrincipal, java.lang.String idStruttura)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getListStruttureInterne",
					_getListStruttureInterneParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					idStruttura);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.StrutturaInternaVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVO> suggestParolaChiave(
		HttpPrincipal httpPrincipal, java.lang.String chiave)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"suggestParolaChiave", _suggestParolaChiaveParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, chiave);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestParolaChiaveVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO> servElencoAnagraficheUffici(
		HttpPrincipal httpPrincipal, java.lang.String chiave,
		java.lang.Integer tipoRicerca) throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"servElencoAnagraficheUffici",
					_servElencoAnagraficheUfficiParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, chiave,
					tipoRicerca);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioSmartVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.UfficioVO> getListUffici(
		HttpPrincipal httpPrincipal, java.lang.String idUfficio)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getListUffici", _getListUfficiParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, idUfficio);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.UfficioVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getPersoneByCodStrut(
		HttpPrincipal httpPrincipal, java.lang.String codStruttura)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getPersoneByCodStrut", _getPersoneByCodStrutParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					codStruttura);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO> servDettagliUfficio(
		HttpPrincipal httpPrincipal, java.lang.String idUfficio)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"servDettagliUfficio", _servDettagliUfficioParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, idUfficio);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaUfficioVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersone(
		HttpPrincipal httpPrincipal, java.lang.String dipartimento,
		java.lang.String direzione, java.lang.String firstName,
		java.lang.String incaricoQualifica, java.lang.String lastName,
		java.lang.String organizzazione, java.lang.String strutturaInterna,
		java.lang.String ufficio) throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getListPersone", _getListPersoneParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					dipartimento, direzione, firstName, incaricoQualifica,
					lastName, organizzazione, strutturaInterna, ufficio);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getListTagForChar(
		HttpPrincipal httpPrincipal, java.lang.String character)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getListTagForChar", _getListTagForCharParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey, character);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.DirezioneVO> getListDirezioni(
		HttpPrincipal httpPrincipal, java.lang.String idDirezione)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getListDirezioni", _getListDirezioniParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					idDirezione);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.DirezioneVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.EnteVO> getListEnti(
		HttpPrincipal httpPrincipal, java.lang.String idEnte)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getListEnti", _getListEntiParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey, idEnte);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.EnteVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO> getGerarchiaByCodStrut(
		HttpPrincipal httpPrincipal, java.lang.String codStruttura)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getGerarchiaByCodStrut",
					_getGerarchiaByCodStrutParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					codStruttura);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.GerarchiaVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO> getListPersoneTelNum(
		HttpPrincipal httpPrincipal, java.lang.String telefono)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getListPersoneTelNum",
					_getListPersoneTelNumParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, telefono);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.AnagraficaVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO> getNuvolaTag(
		HttpPrincipal httpPrincipal, java.lang.Integer numeroTag)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"getNuvolaTag", _getNuvolaTagParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(methodKey, numeroTag);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.TagVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO> suggestLastNameByFirstAndLast(
		HttpPrincipal httpPrincipal, java.lang.String firstName,
		java.lang.String lastName) throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"suggestLastNameByFirstAndLast",
					_suggestLastNameByFirstAndLastParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					firstName, lastName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<it.intranetdag.rubrica.services.vo.xsd.SuggestCognomeVO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.Integer associaTag(HttpPrincipal httpPrincipal,
		java.lang.String codStruttura, java.lang.String tag)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"associaTag", _associaTagParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					codStruttura, tag);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.Integer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.Integer eliminaTag(HttpPrincipal httpPrincipal,
		java.lang.String tag) throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"eliminaTag", _eliminaTagParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(methodKey, tag);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.Integer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.Integer inserisciTag(HttpPrincipal httpPrincipal,
		java.lang.String tagName) throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"inserisciTag", _inserisciTagParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(methodKey, tagName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.Integer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.lang.Integer modificaTag(HttpPrincipal httpPrincipal,
		java.lang.String vecchioTag, java.lang.String nuovoTag)
		throws java.lang.Exception {
		try {
			MethodKey methodKey = new MethodKey(SearchDataServiceUtil.class,
					"modificaTag", _modificaTagParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					vecchioTag, nuovoTag);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof java.lang.Exception) {
					throw (java.lang.Exception)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.lang.Integer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SearchDataServiceHttp.class);
	private static final Class<?>[] _getListCognomiParameterTypes0 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getAlfabetoTagParameterTypes1 = new Class[] {
			
		};
	private static final Class<?>[] _suggestLastNameParameterTypes2 = new Class[] {
			java.lang.String.class, java.lang.String.class
		};
	private static final Class<?>[] _getListStruttureInterneParameterTypes3 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _suggestParolaChiaveParameterTypes4 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _servElencoAnagraficheUfficiParameterTypes5 = new Class[] {
			java.lang.String.class, java.lang.Integer.class
		};
	private static final Class<?>[] _getListUfficiParameterTypes6 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getPersoneByCodStrutParameterTypes7 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _servDettagliUfficioParameterTypes8 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getListPersoneParameterTypes9 = new Class[] {
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class
		};
	private static final Class<?>[] _getListTagForCharParameterTypes10 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getListDirezioniParameterTypes11 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getListEntiParameterTypes12 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getGerarchiaByCodStrutParameterTypes13 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getListPersoneTelNumParameterTypes14 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _getNuvolaTagParameterTypes15 = new Class[] {
			java.lang.Integer.class
		};
	private static final Class<?>[] _suggestLastNameByFirstAndLastParameterTypes16 =
		new Class[] { java.lang.String.class, java.lang.String.class };
	private static final Class<?>[] _associaTagParameterTypes17 = new Class[] {
			java.lang.String.class, java.lang.String.class
		};
	private static final Class<?>[] _eliminaTagParameterTypes18 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _inserisciTagParameterTypes19 = new Class[] {
			java.lang.String.class
		};
	private static final Class<?>[] _modificaTagParameterTypes20 = new Class[] {
			java.lang.String.class, java.lang.String.class
		};
}