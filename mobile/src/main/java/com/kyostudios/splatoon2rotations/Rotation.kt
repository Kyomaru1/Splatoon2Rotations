package com.kyostudios.splatoon2rotation

import com.kyostudios.splatoon2rotations.SplatMap
import java.util.*

class Rotation(val mapAlpha: SplatMap,
               val mapBeta: SplatMap,
               val startTime: Calendar,
               val endTime: Calendar,
               val gameRule: String = "Turf War",
               val isCurrent: Boolean = false,
               val isSplatfest: Boolean = false
)