package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.dto.OrderTogDto;
import com.cokothon.DeliDutch.entity.OrderSep;
import com.cokothon.DeliDutch.entity.OrderTog;
import com.cokothon.DeliDutch.repository.BoardSepRepository;
import com.cokothon.DeliDutch.repository.BoardTogRepository;
import com.cokothon.DeliDutch.repository.OrderTogRepository;
import com.cokothon.DeliDutch.repository.UserRepository;
import com.cokothon.DeliDutch.service.OrderSepService;
import com.cokothon.DeliDutch.service.OrderTogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderTogController {
    private final UserRepository userRepository;
    private final BoardTogRepository boardTogRepository;
    private final OrderTogService orderTogService;

    @PostMapping("/api/v1/orderTog")
    public OrderTogDto makeOrder(@RequestBody OrderTogDto orderTogDto) {

        OrderTog orderTog = OrderTog.builder()
                .boardTog(boardTogRepository.findById(orderTogDto.getBoardTog_id()).get())
                .joinUser(userRepository.findById(orderTogDto.getJoinUser_id()).get()).build();

        return new OrderTogDto(orderTogService.sendOrder(orderTog));
    }
}
