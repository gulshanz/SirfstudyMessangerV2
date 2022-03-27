package com.gulshan.sirfstudymessanger.network.response.chats

import java.io.Serializable

data class UserData(
    val about: String,
    val active: String,
    val address: String,
    val admin: String,
    val android_m_device_id: String,
    val android_n_device_id: String,
    val avatar: String,
    val avatar_full: String,
    val background_image: String,
    val balance: String,
    val birth_privacy: String,
    val birthday: String,
    val city: String,
    val city_id: String,
    val confirm_followers: String,
    val country_id: String,
    val cover: String,
    val daily_points: String,
    val details: DetailsXX,
    val e_accepted: String,
    val e_commented: String,
    val e_followed: String,
    val e_joined_group: String,
    val e_last_notif: String,
    val e_liked: String,
    val e_liked_page: String,
    val e_mentioned: String,
    val e_profile_wall_post: String,
    val e_sentme_msg: String,
    val e_shared: String,
    val e_visited: String,
    val e_wondered: String,
    val email: String,
    val emailNotification: String,
    val email_verified: String,
    val facebook: String,
    val first_name: String,
    val follow_privacy: String,
    val friend_privacy: String,
    val gender: String,
    val google: String,
    val info_file: String,
    val instagram: String,
    val ios_m_device_id: String,
    val ios_n_device_id: String,
    val ip_address: String,
    val is_delete: String,
    val is_pro: String,
    val language: String,
    val last_avatar_mod: String,
    val last_cover_mod: String,
    val last_data_update: String,
    val last_follow_id: String,
    val last_location_update: String,
    val last_login_data: Any,
    val last_name: String,
    val lastseen: String,
    val lastseen_status: String,
    val lastseen_unix_time: String,
    val lat: String,
    val linkedin: String,
    val lng: String,
    val message_privacy: String,
    val mobile_verified: String,
    val mutual_friends_data: List<String>,
    val name: String,
    val new_email: String,
    val new_phone: String,
    val notification_settings: String,
    val notifications_sound: String,
    val order_posts_by: String,
    val parent_email: Any,
    val parent_phone: Any,
    val paypal_email: String,
    val paystack_ref: String,
    val phone_number: String,
    val point_day_expire: String,
    val points: String,
    val post_privacy: String,
    val pro_type: String,
    val ref_user_id: String,
    val referrer: String,
    val registered: String,
    val relationship_id: String,
    val school: String,
    val school_completed: String,
    val service_type: String,
    val share_my_data: String,
    val share_my_location: String,
    val show_activities_privacy: String,
    val state: String,
    val state_id: String,
    val status: String,
    val timezone: String,
    val twitter: String,
    val two_factor: String,
    val two_factor_verified: String,
    val url: String,
    val user_id: String,
    val user_platform: String,
    val user_type: String,
    val username: String,
    val verified: String,
    val visit_privacy: String,
    val vk: String,
    val wallet: String,
    val weather_unit: String,
    val web_device_id: String,
    val website: String,
    val working: String,
    val working_link: String,
    val youtube: String,
    val zip: String
):Serializable