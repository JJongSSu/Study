import { Test, TestingModule } from "@nestjs/testing";
import { MoviesService } from "./movies.service"
import { NotFoundException } from "@nestjs/common";

describe('MovieService', () => {
    let service : MoviesService;

    beforeEach(async () => {
        const module: TestingModule = await Test.createTestingModule({
            providers: [MoviesService],
        }).compile();

        service = module.get<MoviesService>(MoviesService);
    });

    it('should be defined', () => {
        expect(service).toBeDefined();
    });

    describe('getAll', () => {
        it('should return an array', () => {
            const result = service.getAll();
            expect(result).toBeInstanceOf(Array);
        });
    });
    
    describe('getOne', () => {
        it('should return a movie', () => {
            service.create({
                title: "Test Movie",
                genres: ["test"],
                year: 2024,
            });
            const movie = service.getOne(1);
            expect(movie).toBeDefined();
            expect(movie.id).toEqual(1);
            expect(movie.title).toEqual("Test Movie");
        });

        it('should throw 404 error', () => {
            const movieId = 999;
            try{
                service.getOne(movieId);
            }catch(e){
                expect(e).toBeInstanceOf(NotFoundException);
                expect(e.message).toEqual(`Movie with ID ${movieId} not found.`);
            }
        });
    });
    
    describe('create', () => {
        it('should create a movie', () => {
            const beforeMovies = service.getAll().length;
            service.create({
                title: "Test Movie",
                genres: ["test"],
                year: 2024,
            });
            const afterMovies = service.getAll().length;
            expect(afterMovies).toBeGreaterThan(beforeMovies);
        });
    });
    
    describe('deleteOne', () => {
        it('should delete a movie', () => {
            service.create({
                title: "Test Movie",
                genres: ["test"],
                year: 2024,
            });
            const beforeMovies = service.getAll().length;
            service.deleteOne(1);
            const afterMovies = service.getAll().length;
            expect(afterMovies).toEqual(beforeMovies -1);
        });

        it('should throw 404 error', () => {
            const movieId = 999;
            try{
                service.deleteOne(movieId);
            }catch(e){
                expect(e).toBeInstanceOf(NotFoundException);
            }
        });
    });
    
    describe('update', () => {
        it('should update a movie', () => {
            service.create({
                title: "Test Movie",
                genres: ["test"],
                year: 2024,
            });
            service.update(1, {title:"Update Movie"});
            const movie = service.getOne(1);
            expect(movie.title).toEqual("Update Movie");
        });

        it('should throw 404 error', () => {
            const movieId = 999;
            try{
                service.update(movieId, {});
            }catch(e){
                expect(e).toBeInstanceOf(NotFoundException);
            }
        });
    });
});