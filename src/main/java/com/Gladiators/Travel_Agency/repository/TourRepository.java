package com.Gladiators.Travel_Agency.repository;


import com.Gladiators.Travel_Agency.model.Tour;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {

    @Query("SELECT t FROM Tour t WHERE t.startDay = :startDate AND t.returnDay = :returnDate")
    List<Tour> getToursBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("returnDate") LocalDateTime returnDate);



    @Query("SELECT t FROM Tour t WHERE " +
            "(:city IS NULL OR :city = '' OR t.city = :city) " +
            "AND (:adultPrice IS NULL OR t.adultPrice = :adultPrice) " +
            "AND (:childPrice IS NULL OR t.childPrice = :childPrice) " +
            "AND (:adultSeatsNumber IS NULL OR t.adultSeatsNumber = :adultSeatsNumber) " +
            "AND (:childSeatsNumber IS NULL OR t.childSeatsNumber = :childSeatsNumber) " +
            "AND (:hotel IS NULL OR :hotel = '' OR t.hotel = :hotel)"
    )
    List<Tour> findByCityAndStartDayAndReturnDayAndAdultPriceAndChildPriceAndAdultSeatsNumberAndChildSeatsNumberAndHotel(
            @Param("city") String city,
            @Param("adultPrice") Double adultPrice,
            @Param("childPrice") Double childPrice,
            @Param("adultSeatsNumber") Integer adultSeatsNumber,
            @Param("childSeatsNumber") Integer childSeatsNumber,
            @Param("hotel") String hotel);


}
