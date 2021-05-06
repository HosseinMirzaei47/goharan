package com.carpet.goharshad

import com.carpet.goharshad.ToDoFilterQueryBuilderConstants.QUERY_OPERATOR_TYPE_EQUAL

data class ToDoFilterQueryMethod(
    val columnName: String,
    val parameter: Any?,
    val operator: Int = QUERY_OPERATOR_TYPE_EQUAL,
    val targetTable: String = "",
    val targetTableColumn: String = "",
)