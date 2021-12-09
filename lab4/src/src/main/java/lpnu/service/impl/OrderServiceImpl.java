package lpnu.service.impl;

import lpnu.dto.OrderDTO;
import lpnu.entity.Item;
import lpnu.entity.Order;
import lpnu.entity.User;
import lpnu.mapper.OrderToOrderDTOMapper;
import lpnu.repository.OrderRepository;
import lpnu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

        @Autowired
        private OrderToOrderDTOMapper orderMapper;

        @Autowired
        private OrderRepository orderRepository;


    public OrderServiceImpl(final OrderRepository orderRepository, final OrderToOrderDTOMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    @Override
        public List<OrderDTO> getAllOrders() {
            return orderRepository.getAllUsers().stream()
                    .map(e -> orderMapper.toDTO(e))
                    .collect(Collectors.toList());
        }

        @Override
        public OrderDTO getOrderById(final long id) {
            return orderMapper.toDTO(orderRepository.getOrderById(id));
        }

        @Override
        public OrderDTO saveOrder(final OrderDTO orderDTO) {

            final Order order = orderMapper.toEntity(orderDTO);

            orderRepository.saveOrder(order);

            return orderMapper.toDTO(order);
        }

        @Override
        public OrderDTO updateOrder(final OrderDTO orderDTO) {

            final Order order = orderMapper.toEntity(orderDTO);

            return orderMapper.toDTO(orderRepository.updateOrder(order));
        }

        @Override
        public void deleteOrderById(final long id) {
            orderRepository.deleteOrderById(id);
        }



}
