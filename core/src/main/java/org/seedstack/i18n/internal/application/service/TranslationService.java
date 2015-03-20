/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.i18n.internal.application.service;

import org.seedstack.business.api.interfaces.annotations.InterfacesService;

import java.util.Map;

/**
 * This service provide access to the translations stored by the application.
 *
 * @author adrien.lauer@mpsa.com
 * @author pierre.thirouin@ext.mpsa.com
 */
@InterfacesService
public interface TranslationService {

    /**
     * Returns all the keys and their translations for the specified locale.
     * @param locale The locale identifier.
     * @return a map of all the keys and their translations or an empty map
     */
    Map<String, String> getTranslationsForLocale(String locale);
}
