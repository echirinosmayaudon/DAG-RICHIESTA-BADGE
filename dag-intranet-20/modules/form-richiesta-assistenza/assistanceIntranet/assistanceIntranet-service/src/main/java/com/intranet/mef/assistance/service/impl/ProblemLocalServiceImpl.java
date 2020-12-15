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

package com.intranet.mef.assistance.service.impl;

import java.util.List;

import com.intranet.mef.assistance.model.Problem;
import com.intranet.mef.assistance.service.base.ProblemLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the problem local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.intranet.mef.assistance.service.ProblemLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProblemLocalServiceBaseImpl
 * @see com.intranet.mef.assistance.service.ProblemLocalServiceUtil
 */
@ProviderType
public class ProblemLocalServiceImpl extends ProblemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.intranet.mef.assistance.service.ProblemLocalServiceUtil} to access the problem local service.
	 */

	public void add(String problemId, String problemName, String topicId){

		Problem problem= problemPersistence.create(problemId);
		problem.setProblemName(problemName);
		problem.setTopicId(topicId); 

		problemPersistence.update(problem);		

	}

	public List<Problem> findByTopicId(String topicId){
		return problemPersistence.findByTopicsId(topicId);

	}

	public String findProblemNameByPK(String problemId){
		Problem problem = problemPersistence.fetchByPrimaryKey(problemId);

		return problem.getProblemName() ;

	}

	public void removeAll(){
		problemPersistence.removeAll();
	}
}