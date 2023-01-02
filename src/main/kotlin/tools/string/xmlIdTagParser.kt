package tools.string


fun main() {
    val list = """    <string name="message_will_receive_notification">스플의 새 소식을 받아볼까요?</string>
    <string name="message_do_not_miss_benefit_notification">이벤트, 할인혜택 등을 놓치지 마세요</string>
    <string name="title_permit_app_notification">앱 알림 허용하기</string>

    <string name="message_receive_suggestion_alarm">스플 알림을 받아보세요</string>
    <string name="message_turn_on_alarm_and_receive_news">알림을 켜서 관심있는 작품의 업데이트와 이벤트 소식을 받아보세요!</string>
    <string name="message_confirm_receive_alarm">네 받아볼래요!</string>
    <string name="message_confirm_later">다음에 할게요</string>

    <string name="message_turned_off_alarm">알림이 꺼져있어요!</string>
    <string name="title_turn_on_alarm">알림 켜기</string>
    <string name="title_see_a_week_later">일주일동안 보지 않기</string>
    <string name="title_receive_alarm">알림받기</string>

    <string name="message_please_on_system_alarm">스토리플레이의 알림을 받으려면 설정에서 알림을 켜주세요.</string>
    <string name="title_turn_on_system_alarm">기기 알림 켜기</string>
    <string name="title_push_notification">푸시 알림</string>
    <string name="title_notification_like_story">관심 스토리 알림</string>
    <string name="message_notification_description_like_story">보고싶어한 작품 및 추천 작품의 업데이트 알림</string>
    <string name="title_notification_replay">대댓글 알림</string>
    <string name="message_notification_description_replay">내가 쓴 댓글의 대댓글 알림</string>
    <string name="title_notification_like_comment">댓글/대댓글 좋아요 알림</string>
    <string name="message_notification_description_like_comment">내가 쓴 댓글, 답글의 좋아요 알림</string>
    <string name="title_notification_benefit">추천작품/이벤트 혜택 알림</string>
    <string name="message_notification_description_benefit">주천작품 및 다양한 혜택 정보 알림</string>
    <string name="title_notification_author">작가 알림</string>
    <string name="message_notification_description_author">보고싶어한 작가의 업데이트 알림</string>
    <string name="title_push_notification_night">야간 알림</string>
    <string name="message_push_notification_night">야간 알림은 저녁 9시부터 오전 8시까지 보내드립니다</string>""".replace(
                "\n\n",
                "\n"
            ).split("\n")

    list.forEach {
        println(stringTagParser(it.trim()))
    }
}
fun stringTagParser(tag: String): String = tag.replace("<string name=", "")
    .replace("</string>", "")
    .replace("\"", "")
    .split(">")
    .joinToString("\t") { it }


