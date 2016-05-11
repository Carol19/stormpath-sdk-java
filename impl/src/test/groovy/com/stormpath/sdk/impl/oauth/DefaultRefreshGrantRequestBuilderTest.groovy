/*
* Copyright 2015 Stormpath, Inc.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.stormpath.sdk.impl.oauth

import com.stormpath.sdk.oauth.RefreshGrantRequest
import org.testng.annotations.Test

import static org.testng.Assert.assertEquals
import static org.testng.Assert.fail

/**
 * Test for RefreshGrantRequestBuilder class
 *
 * @since 1.0.RC7
 */
class DefaultRefreshGrantRequestBuilderTest {

    @Test
    void testError(){
        def builder = new DefaultRefreshGrantRequestBuilder()

        try {
            builder.build()
            fail("Should have failed")
        } catch (IllegalStateException e){
            assertEquals(e.getMessage(), "refreshToken has not been set. It is a required attribute.")
        }
    }

    @Test
    void testMethods(){
        def builder = new DefaultRefreshGrantRequestBuilder()
        builder.setRefreshToken("test_refresh_token_in_builder")

        RefreshGrantRequest request = builder.build()

        assertEquals request.getRefreshToken(), "test_refresh_token_in_builder"
        assertEquals request.getGrantType(), "refresh_token"
    }
}