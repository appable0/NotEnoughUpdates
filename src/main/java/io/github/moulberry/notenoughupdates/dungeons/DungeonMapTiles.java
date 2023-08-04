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

public class DungeonMapTiles {
	private Color[][] mapColours;
	private final DungeonMapScale scale;

	public RoomColor getUpConnectionCornerColor(int roomX, int roomY) {
		int x = scale.getCornerX(roomX);
		int y = scale.getCornerY(roomY) - 1;
		Color color = mapColours[x][y];
		return RoomColor.fromColor(color);
	}

	public RoomColor getRoomColor(int roomX, int roomY) {
		int x = scale.getCornerX(roomX);
		int y = scale.getCornerY(roomY);
		Color color = mapColours[x][y];
		return RoomColor.fromColor(color);
	}

	public MarkColor getMarkColor(int roomX, int roomY) {
		int x = scale.getCenterX(roomX);
		int y = scale.getCenterY(roomY);
		Color color = mapColours[x][y];
		return MarkColor.fromColor(color);
	}

	public void setMapColours(Color[][] mapColours) {
		this.mapColours = mapColours;
	}

	public DungeonMapTiles(DungeonMapScale scale, Color[][] mapColours) {
		this.scale = scale;
		this.mapColours = mapColours;
	}
}
