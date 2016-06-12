package com.galprom.service;

import com.galprom.model.product.Grid;
import com.galprom.repository.GridRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by MonsterX on 05.04.2016.
 */

//for Pagination
@Service
public class GridServiceImpl {

    private static final int PAGE_SIZE = 10;

    @Inject
    private GridRepository gridRepository;

    public static final int NUMBER_OF_GRID_PER_PAGE = 3;

    public List<Grid> grids(int pageIndex) {
        Page requestedPage = gridRepository.findAll(constructPageSpecification(pageIndex));
        System.out.println(requestedPage.getContent());
        return requestedPage.getContent();
    }

    private Pageable constructPageSpecification(int pageIndex) {
        Pageable pageSpecification = new PageRequest(pageIndex - 1, NUMBER_OF_GRID_PER_PAGE);
        return pageSpecification;
    }

    @SuppressWarnings("unused")
    private Sort sortByLastNameAsc() {
        return new Sort(Sort.Direction.ASC, "name");
    }
}
