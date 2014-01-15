/**
 * Copyright (c) 2012-2013, JCabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.github;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test case for {@link RtReleases}.
 * @author Paul Polishchuk (ppol@ua.fm)
 * @version $Id$
 * @since 0.8
 * @todo #123 RtReleases should be able to get a single release, create, edit
 *  and remove release. When done, remove this puzzle and Ignore annotation from
 *  the methods.
 */
public final class RtReleasesITCase {

    /**
     * RtReleases can iterate releases.
     */
    @Test
    public void canFetchAllReleases() {
        final Releases releases = RtReleasesITCase.releases();
        MatcherAssert.assertThat(
            releases.iterate(),
            Matchers.not(Matchers.emptyIterableOf(Release.class))
        );
    }

    /**
     * RtReleases can fetch a single release.
     * @todo #180 Integration test for RtReleases.get() should be implemented.
     *  Looks like it depends on RtReleases.iterate(), so it can be implemented
     *  only after the iterate() implementation. When done, remove this puzzle
     *  and Ignore annotation from this method.
     */
    @Test
    @Ignore
    public void canFetchRelease() {
        // to be implemented
    }

    /**
     * Create and return RtReleases object to test.
     * @return Releases
     */
    private static Releases releases() {
        final String key = System.getProperty("failsafe.github.key");
        Assume.assumeThat(key, Matchers.notNullValue());
        final Github github = new RtGithub(key);
        return github.repos().get(
            new Coordinates.Simple(System.getProperty("failsafe.github.repo"))
        ).releases();
    }

}