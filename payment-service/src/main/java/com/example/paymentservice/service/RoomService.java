package com.example.paymentservice.service;

import com.example.paymentservice.dto.request.RoomRequest;

public interface RoomService {

    Object updateRoom(RoomRequest request);

    Object createRoome(RoomRequest request);

    Object getRoomByCondition(RoomRequest request);

    Object getRoom(Long idRoom);

}
