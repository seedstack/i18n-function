/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.i18n.internal;

import com.google.common.cache.CacheLoader;
import org.seedstack.i18n.api.LocaleService;
import org.seedstack.i18n.internal.application.service.TranslationService;
import org.apache.commons.lang.StringUtils;
import org.seedstack.seed.core.utils.SeedCheckUtils;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pierre.thirouin@ext.mpsa.com
 *         Date: 28/05/2014
 */
public class I18nCacheLoader extends CacheLoader<String, Map<String, String>> {

    @Inject
    private TranslationService messageService;

    @Inject
    private LocaleService localeService;

    @Override
    public Map<String, String> load(String key) {
        SeedCheckUtils.checkIfNotNull(key);
        // If the default locale is not available, then the application is not configured
        if (StringUtils.isNotBlank(localeService.getDefaultLocale())) {
            return messageService.getTranslationsForLocale(key);
        } else {
            return new HashMap<String, String>();
        }
    }
}
