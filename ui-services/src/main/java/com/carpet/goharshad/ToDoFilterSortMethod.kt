package com.carpet.goharshad

import com.carpet.goharshad.ToDoFilterQueryBuilderConstants.ORDER_TYPE_ASC

data class ToDoFilterSortMethod(
    val nameOfColumn: String,
    val orderType: Int = ORDER_TYPE_ASC,
)