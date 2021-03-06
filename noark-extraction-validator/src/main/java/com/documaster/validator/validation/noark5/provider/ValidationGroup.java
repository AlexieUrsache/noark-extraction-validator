/**
 * Noark Extraction Validator
 * Copyright (C) 2016, Documaster AS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.documaster.validator.validation.noark5.provider;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

import com.documaster.validator.validation.collector.ValidationCollector;

@XmlType(name = "group")
@XmlEnum
public enum ValidationGroup {

	@XmlEnumValue("arkivstruktur")
	ARCHIVE_STRUCTURE("arkivstruktur", "AS"),

	@XmlEnumValue("loependejournal")
	RUNNING_JOURNAL("loependejournal", "LJ"),

	@XmlEnumValue("offentligjournal")
	PUBLIC_JOURNAL("offentligjournal", "OJ"),

	@XmlEnumValue("arkivuttrekk")
	TRANSFER_EXPORTS("addml", "AU"),

	@XmlEnumValue("endringslogg")
	CHANGE_LOG("endringslogg", "EL"),

	@XmlEnumValue("package")
	PACKAGE("package", "P"),

	@XmlEnumValue("exceptions")
	EXCEPTIONS("exceptions", "E");

	private final String name;
	private final String prefix;

	ValidationGroup(String name, String prefix) {

		this.name = name;
		this.prefix = prefix;
	}

	public String getName() {

		return name;
	}

	public String getGroupPrefix() {

		return prefix;
	}

	public String getNextGroupId(ValidationCollector collector) {

		return prefix + (collector.getTotalResultCountIn(name) + 1);
	}
}
