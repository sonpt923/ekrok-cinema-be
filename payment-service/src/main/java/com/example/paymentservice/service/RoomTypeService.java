package com.example.paymentservice.service;

import com.example.paymentservice.entity.RoomType;

public interface RoomTypeService {

    Object createRoomType(RoomType roomType);

    Object updateRoomType(RoomType roomType);

    Object getRoomTypeById(long id);

}
