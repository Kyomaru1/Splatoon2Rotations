package com.kyostudios.splatoon2rotations

import android.content.res.Resources
import org.json.JSONObject
import java.util.*

class RotationCard(){

    var mapAImageID: Int = 0
    var mapBImageID: Int = 0
    var mapATitle: String = ""
    var mapBTitle: String = ""
    var startHour: Int = 0
    var endHour: Int = 0
    var gameRule: String = ""
    var iscurrent: Boolean = false;
    var isSplatfest: Boolean = false;

    companion object {
        fun newInstance(gameRule: String,
                        mapAID: Int,
                        mapBID: Int,
                        startTime: Calendar,
                        endTime: Calendar,
                        isCurrent: Boolean,
                        isSplatfest: Boolean,
                        res:Resources): RotationCard {
            var card: RotationCard = RotationCard()
            when (mapAID + 1) {
                1 -> {card.mapATitle = res.getString(R.string.stage_0); card.mapAImageID = R.drawable.stage_0}
                2 -> {card.mapATitle = res.getString(R.string.stage_1); card.mapAImageID = R.drawable.stage_1 }
                3 -> {card.mapATitle = res.getString(R.string.stage_2); card.mapAImageID = R.drawable.stage_2 }
                4 -> {card.mapATitle = res.getString(R.string.stage_3); card.mapAImageID = R.drawable.stage_3 }
                5 -> {card.mapATitle = res.getString(R.string.stage_4); card.mapAImageID = R.drawable.stage_4 }
                6 -> {card.mapATitle = res.getString(R.string.stage_5); card.mapAImageID = R.drawable.stage_5 }
                7 -> {card.mapATitle = res.getString(R.string.stage_6); card.mapAImageID = R.drawable.stage_6 }
                8 -> {card.mapATitle = res.getString(R.string.stage_7); card.mapAImageID = R.drawable.stage_7 }
                9 -> {card.mapATitle = res.getString(R.string.stage_8); card.mapAImageID = R.drawable.stage_8 }
                10 -> {card.mapATitle = res.getString(R.string.stage_9); card.mapAImageID = R.drawable.stage_9 }
                11 -> {card.mapATitle = res.getString(R.string.stage_10); card.mapAImageID = R.drawable.stage_10 }
                12 -> {card.mapATitle = res.getString(R.string.stage_11); card.mapAImageID = R.drawable.stage_11 }
                13 -> {card.mapATitle = res.getString(R.string.stage_12); card.mapAImageID = R.drawable.stage_12 }
                14 -> {card.mapATitle = res.getString(R.string.stage_13); card.mapAImageID = R.drawable.stage_13 }
                15 -> {card.mapATitle = res.getString(R.string.stage_14); card.mapAImageID = R.drawable.stage_14 }
                16 -> {card.mapATitle = res.getString(R.string.stage_15); card.mapAImageID = R.drawable.stage_15 }
                17 -> {card.mapATitle = res.getString(R.string.stage_16); card.mapAImageID = R.drawable.stage_16 }
                18 -> {card.mapATitle = res.getString(R.string.stage_17); card.mapAImageID = R.drawable.stage_17 }
                19 -> {card.mapATitle = res.getString(R.string.stage_18); card.mapAImageID = R.drawable.stage_18 }
                20 -> {card.mapATitle = res.getString(R.string.stage_19); card.mapAImageID = R.drawable.stage_19 }
                21 -> {card.mapATitle = res.getString(R.string.stage_20); card.mapAImageID = R.drawable.stage_20 }
                22 -> {card.mapATitle = res.getString(R.string.stage_21); card.mapAImageID = R.drawable.stage_21 }
                23 -> {card.mapATitle = res.getString(R.string.stage_22); card.mapAImageID = R.drawable.stage_22 }
                10000 -> {card.mapATitle =res.getString(R.string.stage_9999); card.mapAImageID = R.drawable.stage_9999 }
            }

            when (mapBID + 1) {
                1 -> {card.mapBTitle = res.getString(R.string.stage_0); card.mapBImageID = R.drawable.stage_0}
                2 -> {card.mapBTitle = res.getString(R.string.stage_1); card.mapBImageID = R.drawable.stage_1}
                3 -> {card.mapBTitle = res.getString(R.string.stage_2); card.mapBImageID = R.drawable.stage_2}
                4 -> {card.mapBTitle = res.getString(R.string.stage_3); card.mapBImageID = R.drawable.stage_3}
                5 -> {card.mapBTitle = res.getString(R.string.stage_4); card.mapBImageID = R.drawable.stage_4}
                6 -> {card.mapBTitle = res.getString(R.string.stage_5); card.mapBImageID = R.drawable.stage_5}
                7 -> {card.mapBTitle = res.getString(R.string.stage_6); card.mapBImageID = R.drawable.stage_6}
                8 -> {card.mapBTitle = res.getString(R.string.stage_7); card.mapBImageID = R.drawable.stage_7}
                9 -> {card.mapBTitle = res.getString(R.string.stage_8); card.mapBImageID = R.drawable.stage_8}
                10 -> {card.mapBTitle = res.getString(R.string.stage_9); card.mapBImageID = R.drawable.stage_9}
                11 -> {card.mapBTitle = res.getString(R.string.stage_10); card.mapBImageID = R.drawable.stage_10}
                12 -> {card.mapBTitle = res.getString(R.string.stage_11); card.mapBImageID = R.drawable.stage_11}
                13 -> {card.mapBTitle = res.getString(R.string.stage_12); card.mapBImageID = R.drawable.stage_12}
                14 -> {card.mapBTitle = res.getString(R.string.stage_13); card.mapBImageID = R.drawable.stage_13}
                15 -> {card.mapBTitle = res.getString(R.string.stage_14); card.mapBImageID = R.drawable.stage_14}
                16 -> {card.mapBTitle = res.getString(R.string.stage_15); card.mapBImageID = R.drawable.stage_15}
                17 -> {card.mapBTitle = res.getString(R.string.stage_16); card.mapBImageID = R.drawable.stage_16}
                18 -> {card.mapBTitle = res.getString(R.string.stage_17); card.mapBImageID = R.drawable.stage_17}
                19 -> {card.mapBTitle = res.getString(R.string.stage_18); card.mapBImageID = R.drawable.stage_18}
                20 -> {card.mapBTitle = res.getString(R.string.stage_19); card.mapBImageID = R.drawable.stage_19}
                21 -> {card.mapBTitle = res.getString(R.string.stage_20); card.mapBImageID = R.drawable.stage_20}
                22 -> {card.mapBTitle = res.getString(R.string.stage_21); card.mapBImageID = R.drawable.stage_21}
                23 -> {card.mapBTitle = res.getString(R.string.stage_22); card.mapBImageID = R.drawable.stage_22}
                10000 -> {card.mapBTitle = res.getString(R.string.stage_9999); card.mapBImageID = R.drawable.stage_9999}
            }

            card.iscurrent = isCurrent
            card.isSplatfest = isSplatfest
            card.startHour = startTime.get(Calendar.HOUR_OF_DAY)
            card.endHour = endTime.get(Calendar.HOUR_OF_DAY)
            card.gameRule = JSONObject(gameRule)["name"] as String

            return card
        }
    }


}