/*
 * Copyright 2012-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.actuate.web.mappings.reactive;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.boot.actuate.web.mappings.RequestMappingAbstractCondition ;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.result.condition.MediaTypeExpression;
import org.springframework.web.reactive.result.condition.NameValueExpression;
import org.springframework.web.reactive.result.method.RequestMappingInfo;
import org.springframework.web.util.pattern.PathPattern;

/**
 * Description of the conditions of a {@link RequestMappingInfo}.
 *
 * @author Andy Wilkinson
 * @since 2.0.0
 */
public class RequestMappingConditionsDescription extends RequestMappingAbstractCondition{


	RequestMappingConditionsDescription(RequestMappingInfo requestMapping) {
		super(requestMapping);
		super.patterns = requestMapping.getPatternsCondition().getPatterns().stream().map(PathPattern::getPatternString)
				.collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

	}

	

}
