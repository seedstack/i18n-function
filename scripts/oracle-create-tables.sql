--
-- Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
--
-- This Source Code Form is subject to the terms of the Mozilla Public
-- License, v. 2.0. If a copy of the MPL was not distributed with this
-- file, You can obtain one at http://mozilla.org/MPL/2.0/.
--

CREATE TABLE SEED_I18N_KEY (
	ID VARCHAR2(255) NOT NULL,
	DESCRIPTION VARCHAR2(255),
	OUTDATED VARCHAR2(5),
	PRIMARY KEY (ID)
);
CREATE TABLE SEED_I18N_KEY_TRANS (
	TRANS_ID_FK VARCHAR2(255) NOT NULL,
	TRANSLATIONS_KEY_ID VARCHAR2(255) NOT NULL,
	TRANSLATIONS_LOCALE VARCHAR2(255) NOT NULL,
	PRIMARY KEY (TRANS_ID_FK,TRANSLATIONS_KEY_ID,TRANSLATIONS_LOCALE)
);
CREATE TABLE SEED_I18N_LOCALE (
	CODE VARCHAR2(255) NOT NULL,
	DEFAULT_LOCALE VARCHAR2(5),
	ENGLISH_LANGUAGE VARCHAR2(255),
	LANGUAGE VARCHAR2(255),
	PRIMARY KEY (CODE)
);
CREATE TABLE SEED_I18N_TRANSLATION (
	KEY_ID VARCHAR2(255) NOT NULL,
	LOCALE VARCHAR2(255) NOT NULL,
	APPROXIMATE VARCHAR2(5),
	OUTDATED VARCHAR2(5),
	TRANSLATION VARCHAR2(255),
	PRIMARY KEY (KEY_ID,LOCALE)
);
ALTER TABLE SEED_I18N_KEY_TRANS
	ADD FOREIGN KEY (TRANSLATIONS_KEY_ID) 
	REFERENCES SEED_I18N_TRANSLATION (KEY_ID);

ALTER TABLE SEED_I18N_KEY_TRANS
	ADD FOREIGN KEY (TRANS_ID_FK) 
	REFERENCES SEED_I18N_KEY (ID);

ALTER TABLE SEED_I18N_KEY_TRANS
	ADD FOREIGN KEY (TRANSLATIONS_LOCALE) 
	REFERENCES SEED_I18N_TRANSLATION (LOCALE);

