package tools.string

fun main() {
    println(makeEventConstValue("touch_opt_in_notification_card"))
    println(makeEventConstValue("view_opt_in_notification_card"))
    println(makeEventConstValue("view_opt_in_bottomsheet"))
    println(makeEventConstValue("touch_opt_in_bottomsheet_ok"))
    println(makeEventConstValue("touch_opt_in_bottomsheet_dismiss"))
    println(makeEventConstValue("push_detail_story_ok"))
    println(makeEventConstValue("push_detail_comment_ok"))
    println(makeEventConstValue("push_detail_like_ok"))
    println(makeEventConstValue("push_detail_event_ok"))
    println(makeEventConstValue("push_detail_writer_ok"))
}

fun makeEventConstValue(input: String): String {
    return "const val EVENT_${input.uppercase()} = \"${input}\""
}