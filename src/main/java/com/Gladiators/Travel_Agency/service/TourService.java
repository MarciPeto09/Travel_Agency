package com.Gladiators.Travel_Agency.service;


import com.Gladiators.Travel_Agency.dto.RequestTourDto;
import com.Gladiators.Travel_Agency.dto.ResponsTourDto;
import com.Gladiators.Travel_Agency.mapper.MapperTour;
import com.Gladiators.Travel_Agency.model.Tour;
import com.Gladiators.Travel_Agency.repository.TourRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class TourService {

//    @Autowired
    private TourRepository tourRepo;

    private MapperTour mapper;


    public List<ResponsTourDto> findAll(){
      List<Tour> listTour = tourRepo.findAll();
//        return listTour.stream().map(t -> mapper.mapToResponse(t))
//                .toList();

        List<ResponsTourDto> responsTourDtoList = new ArrayList<>();

        for (Tour t : listTour) {
          responsTourDtoList.add(mapper.mapToResponse(t)) ;

        }

        return responsTourDtoList;



    }

    public  Tour getTourById(Long id)  {
        return tourRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("This tour id does not exist!"));
    }

    public void deleteTourById(Long id){
        Tour existingTour = tourRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("This tour id does not exist!"));

        if(existingTour != null){
            tourRepo.delete(existingTour);
        }else{
            throw new RuntimeException("This tour id does not exist!");
        }
    }

    public ResponsTourDto save(RequestTourDto request) {
        Tour tour = mapper.mapToEntity(request);

        Tour savedTour = tourRepo.save(tour);

        return mapper.mapToResponse(savedTour);

    }

}
