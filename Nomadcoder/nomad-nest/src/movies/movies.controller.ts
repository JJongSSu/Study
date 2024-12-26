import { Body, Controller, Delete, Get, Param, Patch, Post, Put, Query } from '@nestjs/common';
import { MoviesService } from './movies.service';
import { Movie } from './entities/movie.entity';
import { CreateMovieDto } from './dto/createMovie.dto';
import { UpdateMovieDto } from './dto/updateMovie.dto';

@Controller('movies')
export class MoviesController {
    constructor(private readonly moviesService: MoviesService){}

    @Get()
    getAll(): Movie[]{
        return this.moviesService.getAll();
    }

    // 데코레이션에서 /:id보다 밑에 있으면 나머지 Get의 인자들을 id로 판단함.
    @Get("/search")
    search(@Query("year") searchingYear: string){
        return `we are searching for a movie made after: ${searchingYear}`;
    }

    // Param은 url에 있는 요소를 받아옴. 데코레이터에 있는 인자와 이름이 같아야 함.
    @Get("/:id")
    getOne(@Param("id") movieId:number): Movie{
        return this.moviesService.getOne(movieId);
    }

    @Post()
    create(@Body() movieData:CreateMovieDto){
        return this.moviesService.create(movieData);
    }

    @Delete("/:id")
    remove(@Param("id") movieId:number){
        return this.moviesService.deleteOne(movieId);
    }

    // Patch는 부분 Update, Put은 전체(모든 리소스) Update
    @Patch('/:id')
    patch(@Param("id") movieId:number, @Body() updateData:UpdateMovieDto){
        return this.moviesService.update(movieId, updateData);
    }
}
