package com.example.kakaopractice;

import com.example.kakaopractice.domain.cart.service.CartWriteService;
import com.example.kakaopractice.domain.option.entity.Option;
import com.example.kakaopractice.domain.option.service.OptionReadService;
import com.example.kakaopractice.domain.option.service.OptionWriteService;
import com.example.kakaopractice.domain.order.service.OrderWriteService;
import com.example.kakaopractice.domain.product.service.ProductWriteService;
import com.example.kakaopractice.domain.user.service.UserWriteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KakaoPracticeApplicationTests {

    @Autowired
    private UserWriteService userWriteService;

    @Autowired
    private ProductWriteService productWriteService;

    @Autowired
    OptionWriteService optionWriteService;

    @Autowired
    OptionReadService optionReadService;

    @Autowired
    CartWriteService cartWriteService;

    @Autowired
    OrderWriteService orderWriteService;

//    @Autowired
//    UserController userController;

    @Test
    void createUserTest() {
        userWriteService.createDummyUser();
        userWriteService.createDummyUser();
        userWriteService.createDummyUser();
        userWriteService.createDummyUser();
        userWriteService.createDummyUser();
        userWriteService.createDummyUser();
    }

    @Test
    void createProductTest() {
        String description = "설명입니다.";

        productWriteService.create(
                "기본에 슬라이딩 지퍼백 크리스마스/플라워에디션 에디션 외 주방용품 특가전",
                description,
                "/images/1.jpg",
                1000);

        productWriteService.create(
                "[황금약단밤 골드]2022년산 햇밤 칼집밤700g외/군밤용/생율",
                description,
                "/images/2.jpg",
                2000);

        productWriteService.create(
                "삼성전자 JBL JR310 외 어린이용/성인용 헤드셋 3종!",
                description,
                "/images/3.jpg",
                30000);

        productWriteService.create(
                "바른 누룽지맛 발효효소 2박스 역가수치보장 / 외 7종",
                description,
                "/images/4.jpg",
                4000);

        productWriteService.create(
                "[더주] 컷팅말랑장족, 숏다리 100g/300g 외 주전부리모음 /중독성 최고/마른안주",
                description,
                "/images/5.jpg",
                5000);

        productWriteService.create(
                "굳지않는 앙금절편 1,050g 2팩 외 우리쌀떡 모음전",
                description,
                "/images/6.jpg",
                15900);

        productWriteService.create(
                "eoe 이너딜리티 30포, 오렌지맛 고 식이섬유 보충제",
                description,
                "/images/7.jpg",
                26800);

        productWriteService.create(
                "제나벨 PDRN 크림 2개. 피부보습/진정 케어",
                description,
                "/images/8.jpg",
                25900);

        productWriteService.create(
                "플레이스테이션 VR2 호라이즌 번들. 생생한 몰입감",
                description,
                "/images/9.jpg",
                797000);
    }

    @Test
    void createOptionTest() {
        for (int i = 0; i < 10; i ++) {
            if (i >= 5) {
                optionWriteService.create("옵션" + i, (1000 * i), 2L);
            } else {
                optionWriteService.create("옵션" + i, (1000 * i), 3L);
            }
        }
    }

    @Test
    void addCartTest() {
        cartWriteService.addCart(2L, 1L, 5);
        cartWriteService.addCart(2L, 3L, 5);
        cartWriteService.addCart(3L, 2L, 3);
    }

    @Test
    void orderTest() {
        orderWriteService.doOrder(2L);
    }


    @Test
    void createAllTest() {
        createUserTest();
        createProductTest();
        createOptionTest();
        addCartTest();
        orderTest();
    }

    @Test
    void modifyOptionPriceTest() {
        // 옵션가격을 변경했을 때, order_item_tb는 변하지 않는다.

        Option option = optionReadService.getOptionById(2L);
        System.out.println(option.getPrice());

        optionWriteService.modifyPrice(2L, 10000);
        System.out.println(option.getPrice()); // 1000 (기존 객체는 변하지 않는다)

        Option option2 = optionReadService.getOptionById(2L);
        System.out.println(option2.getPrice()); // 10000 (새로 조회를 하면, 바뀌어있다)
    }

//    @Test
//    void duplicateEmailCheckTest() {
//        String email = "abc@abc.com";
//        ApiResponse apiResponse = userController.checkDuplicateEmail(email);
//        System.out.println(apiResponse);
//    }
//
//    @Test
//    void notDuplicateEmailCheckTest() {
//        String email = "aa@aa.com";
//        ApiResponse apiResponse = userController.checkDuplicateEmail(email);
//        System.out.println(apiResponse);
//    }
}
