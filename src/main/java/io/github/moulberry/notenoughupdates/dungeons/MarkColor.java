/*
 * Copyright (C) 2023 NotEnoughUpdates contributors
 *
 * This file is part of NotEnoughUpdates.
 *
 * NotEnoughUpdates is free software: you can redistribute it
 * and/or modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * NotEnoughUpdates is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with NotEnoughUpdates. If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.moulberry.notenoughupdates.dungeons;

import java.awt.*;

public enum MarkColor {
	GREEN_CHECK(new Color(0, 124, 0)),
	RED_CROSS(new Color(255, 0, 0)),
	QUESTION(new Color(13, 13, 13)),
	WHITE_CHECK(new Color(255, 255, 255));

	public final Color color;

	MarkColor(Color color) {
		this.color = color;
	}

	public static MarkColor fromColor(Color color) {
		for (MarkColor mapColor : MarkColor.values()) {
			if (mapColor.color.equals(color)) {
				return mapColor;
			}
		}
		return null;
	}
}
