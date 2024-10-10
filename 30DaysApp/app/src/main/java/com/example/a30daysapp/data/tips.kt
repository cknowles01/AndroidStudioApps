package com.example.a30daysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysapp.R

data class Tip(
    @StringRes val day: Int,
    @StringRes val tipname: Int,
    @StringRes val quote: Int,

)

val tips = listOf(
    Tip(R.string.tip_day_1, R.string.tip_name_1, R.string.tip_quote_1),
    Tip(R.string.tip_day_2, R.string.tip_name_2, R.string.tip_quote_2),
    Tip(R.string.tip_day_3, R.string.tip_name_3, R.string.tip_quote_3),
    Tip(R.string.tip_day_4, R.string.tip_name_4, R.string.tip_quote_4),
    Tip(R.string.tip_day_5, R.string.tip_name_5, R.string.tip_quote_5),
    Tip(R.string.tip_day_6, R.string.tip_name_6, R.string.tip_quote_6),
    Tip(R.string.tip_day_7, R.string.tip_name_7, R.string.tip_quote_7),
    Tip(R.string.tip_day_8, R.string.tip_name_8, R.string.tip_quote_8),
    Tip(R.string.tip_day_9, R.string.tip_name_9, R.string.tip_quote_9),
    Tip(R.string.tip_day_10, R.string.tip_name_10, R.string.tip_quote_10),
    Tip(R.string.tip_day_11, R.string.tip_name_11, R.string.tip_quote_11),
    Tip(R.string.tip_day_12, R.string.tip_name_12, R.string.tip_quote_12),
    Tip(R.string.tip_day_13, R.string.tip_name_13, R.string.tip_quote_13),
    Tip(R.string.tip_day_14, R.string.tip_name_14, R.string.tip_quote_14),
    Tip(R.string.tip_day_15, R.string.tip_name_15, R.string.tip_quote_15),
    Tip(R.string.tip_day_16, R.string.tip_name_16, R.string.tip_quote_16),
    Tip(R.string.tip_day_17, R.string.tip_name_17, R.string.tip_quote_17),
    Tip(R.string.tip_day_18, R.string.tip_name_18, R.string.tip_quote_18),
    Tip(R.string.tip_day_19, R.string.tip_name_19, R.string.tip_quote_19),
    Tip(R.string.tip_day_20, R.string.tip_name_20, R.string.tip_quote_20),
    Tip(R.string.tip_day_21, R.string.tip_name_21, R.string.tip_quote_21),
    Tip(R.string.tip_day_22, R.string.tip_name_22, R.string.tip_quote_22),
    Tip(R.string.tip_day_23, R.string.tip_name_23, R.string.tip_quote_23),
    Tip(R.string.tip_day_24, R.string.tip_name_24, R.string.tip_quote_24),
    Tip(R.string.tip_day_25, R.string.tip_name_25, R.string.tip_quote_25),
    Tip(R.string.tip_day_26, R.string.tip_name_26, R.string.tip_quote_26),
    Tip(R.string.tip_day_27, R.string.tip_name_27, R.string.tip_quote_27),
    Tip(R.string.tip_day_28, R.string.tip_name_28, R.string.tip_quote_28),
    Tip(R.string.tip_day_29, R.string.tip_name_29, R.string.tip_quote_29),
    Tip(R.string.tip_day_30, R.string.tip_name_30, R.string.tip_quote_30),
)