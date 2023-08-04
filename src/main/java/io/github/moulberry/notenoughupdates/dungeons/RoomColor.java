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


public enum RoomColor {
	BROWN(new Color(114, 67, 27)),
	GRAY(new Color(65, 65, 65)),
	GREEN(new Color(0, 124, 0)),
	PINK(new Color(242, 127, 165)),
	PURPLE(new Color(178, 76, 216)),
	RED(new Color(255, 0, 0)),
	YELLOW(new Color(229, 229, 51)),
	ORANGE(new Color(216, 127, 51));

	public final Color color;

	RoomColor(Color color) {
		this.color = color;
	}

	public static RoomColor fromColor(Color color) {
		for (RoomColor mapColor : RoomColor.values()) {
			if (mapColor.color.equals(color)) {
				return mapColor;
			}
		}
		return null;
	}
}
