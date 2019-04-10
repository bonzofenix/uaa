/*
 * ******************************************************************************
 *       Cloud Foundry Copyright (c) [2009-2015] Pivotal Software, Inc. All Rights Reserved.
 *
 *       This product is licensed to you under the Apache License, Version 2.0 (the "License").
 *       You may not use this product except in compliance with the License.
 *
 *       This product includes a number of subcomponents with
 *       separate copyright notices and license terms. Your use of these
 *       subcomponents is subject to the terms and conditions of the
 *       subcomponent's license, as noted in the LICENSE file.
 * ******************************************************************************
 */

package org.cloudfoundry.identity.uaa.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.EMAIL;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.EMAIL_VERIFIED;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.FAMILY_NAME;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.GIVEN_NAME;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.NAME;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.PHONE_NUMBER;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.PREVIOUS_LOGON_TIME;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.ROLES;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.SUB;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.USER_ATTRIBUTES;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.USER_ID;
import static org.cloudfoundry.identity.uaa.oauth.token.ClaimConstants.USER_NAME;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserInfoResponse {
    @JsonProperty(USER_ID)
    public String userId;

    @JsonProperty(USER_NAME)
    public String userName;

    public String name;

    @JsonProperty(GIVEN_NAME)
    public String givenName;

    @JsonProperty(FAMILY_NAME)
    public String familyName;

    @JsonProperty(PHONE_NUMBER)
    public String phoneNumber;

    @JsonProperty(EMAIL)
    public String email;

    @JsonProperty(EMAIL_VERIFIED)
    public boolean emailVerified;

    @JsonInclude
    @JsonProperty(PREVIOUS_LOGON_TIME)
    public Long previousLogonSuccess;

    @JsonProperty(USER_ATTRIBUTES)
    public Map<String, List<String>> userAttributes;

    @JsonProperty(ROLES)
    public List<String> roles;

    @JsonProperty(NAME)
    public String getFullName() {
        return (givenName != null ? givenName : "")
            + (familyName != null ? " " + familyName : "");
    }

    @JsonProperty(SUB)
    public String getSub() {
        return userId;
    }

}
