package com.kyostudios.splatoon2rotations

import java.util.*

class RotationCard(){

    var mapAImageID: Int = 0
    var mapBImageID: Int = 0
    var mapATitle: String = ""
    var mapBTitle: String = ""
    var startHour: Int = 0
    var endHour: Int = 0
    var gameRule: String = ""

    companion object {
        fun newInstance(gameRule: String,
                        mapAID: Int,
                        mapBID: Int,
                        startTime: Calendar,
                        endTime: Calendar,
                        isCurrent: Boolean,
                        isSplatfest: Boolean): RotationCard {
            var card: RotationCard = RotationCard()
            when (mapAID) {
                1 -> {card.mapATitle = R.string.stage_0.toString(); card.mapAImageID = R.drawable.stage_0}
                2 -> {card.mapATitle = R.string.stage_1.toString(); card.mapAImageID = R.drawable.stage_1 }
                3 -> {card.mapATitle = R.string.stage_2.toString(); card.mapAImageID = R.drawable.stage_2 }
                4 -> {card.mapATitle = R.string.stage_3.toString(); card.mapAImageID = R.drawable.stage_3 }
                5 -> {card.mapATitle = R.string.stage_4.toString(); card.mapAImageID = R.drawable.stage_4 }
                6 -> {card.mapATitle = R.string.stage_5.toString(); card.mapAImageID = R.drawable.stage_5 }
                7 -> {card.mapATitle = R.string.stage_6.toString(); card.mapAImageID = R.drawable.stage_6 }
                8 -> {card.mapATitle = R.string.stage_7.toString(); card.mapAImageID = R.drawable.stage_7 }
                9 -> {card.mapATitle = R.string.stage_8.toString(); card.mapAImageID = R.drawable.stage_8 }
                10 -> {card.mapATitle = R.string.stage_9.toString(); card.mapAImageID = R.drawable.stage_9 }
                11 -> {card.mapATitle = R.string.stage_10.toString(); card.mapAImageID = R.drawable.stage_10 }
                12 -> {card.mapATitle = R.string.stage_11.toString(); card.mapAImageID = R.drawable.stage_11 }
                13 -> {card.mapATitle = R.string.stage_12.toString(); card.mapAImageID = R.drawable.stage_12 }
                14 -> {card.mapATitle = R.string.stage_13.toString(); card.mapAImageID = R.drawable.stage_13 }
                15 -> {card.mapATitle = R.string.stage_14.toString(); card.mapAImageID = R.drawable.stage_14 }
                16 -> {card.mapATitle = R.string.stage_15.toString(); card.mapAImageID = R.drawable.stage_15 }
                17 -> {card.mapATitle = R.string.stage_16.toString(); card.mapAImageID = R.drawable.stage_16 }
                18 -> {card.mapATitle = R.string.stage_17.toString(); card.mapAImageID = R.drawable.stage_17 }
                19 -> {card.mapATitle = R.string.stage_18.toString(); card.mapAImageID = R.drawable.stage_18 }
                20 -> {card.mapATitle = R.string.stage_19.toString(); card.mapAImageID = R.drawable.stage_19 }
                21 -> {card.mapATitle = R.string.stage_20.toString(); card.mapAImageID = R.drawable.stage_20 }
                22 -> {card.mapATitle = R.string.stage_21.toString(); card.mapAImageID = R.drawable.stage_21 }
                23 -> {card.mapATitle = R.string.stage_22.toString(); card.mapAImageID = R.drawable.stage_22 }
                9999 -> {card.mapATitle = R.string.stage_9999.toString(); card.mapAImageID = R.drawable.stage_9999 }
            }

            when (mapBID) {
                1 -> {card.mapBTitle = R.string.stage_0.toString(); card.mapBImageID = R.drawable.stage_0}
                2 -> {card.mapBTitle = R.string.stage_1.toString(); card.mapBImageID = R.drawable.stage_1}
                3 -> {card.mapBTitle = R.string.stage_2.toString(); card.mapBImageID = R.drawable.stage_2}
                4 -> {card.mapBTitle = R.string.stage_3.toString(); card.mapBImageID = R.drawable.stage_3}
                5 -> {card.mapBTitle = R.string.stage_4.toString(); card.mapBImageID = R.drawable.stage_4}
                6 -> {card.mapBTitle = R.string.stage_5.toString(); card.mapBImageID = R.drawable.stage_5}
                7 -> {card.mapBTitle = R.string.stage_6.toString(); card.mapBImageID = R.drawable.stage_6}
                8 -> {card.mapBTitle = R.string.stage_7.toString(); card.mapBImageID = R.drawable.stage_7}
                9 -> {card.mapBTitle = R.string.stage_8.toString(); card.mapBImageID = R.drawable.stage_8}
                10 -> {card.mapBTitle = R.string.stage_9.toString(); card.mapBImageID = R.drawable.stage_9}
                11 -> {card.mapBTitle = R.string.stage_10.toString(); card.mapBImageID = R.drawable.stage_10}
                12 -> {card.mapBTitle = R.string.stage_11.toString(); card.mapBImageID = R.drawable.stage_11}
                13 -> {card.mapBTitle = R.string.stage_12.toString(); card.mapBImageID = R.drawable.stage_12}
                14 -> {card.mapBTitle = R.string.stage_13.toString(); card.mapBImageID = R.drawable.stage_13}
                15 -> {card.mapBTitle = R.string.stage_14.toString(); card.mapBImageID = R.drawable.stage_14}
                16 -> {card.mapBTitle = R.string.stage_15.toString(); card.mapBImageID = R.drawable.stage_15}
                17 -> {card.mapBTitle = R.string.stage_16.toString(); card.mapBImageID = R.drawable.stage_16}
                18 -> {card.mapBTitle = R.string.stage_17.toString(); card.mapBImageID = R.drawable.stage_17}
                19 -> {card.mapBTitle = R.string.stage_18.toString(); card.mapBImageID = R.drawable.stage_18}
                20 -> {card.mapBTitle = R.string.stage_19.toString(); card.mapBImageID = R.drawable.stage_19}
                21 -> {card.mapBTitle = R.string.stage_20.toString(); card.mapBImageID = R.drawable.stage_20}
                22 -> {card.mapBTitle = R.string.stage_21.toString(); card.mapBImageID = R.drawable.stage_21}
                23 -> {card.mapBTitle = R.string.stage_22.toString(); card.mapBImageID = R.drawable.stage_22}
                9999 -> {card.mapBTitle = R.string.stage_9999.toString(); card.mapBImageID = R.drawable.stage_9999}
            }

            card.startHour = startTime.get(Calendar.HOUR)
            card.endHour = endTime.get(Calendar.HOUR)
            card.gameRule = gameRule

            return card
        }
    }


}