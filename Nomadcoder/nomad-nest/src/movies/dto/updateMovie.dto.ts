import { PartialType } from "@nestjs/mapped-types";
import { CreateMovieDto } from "./createMovie.dto";

// code 간결성, 쿼리에 대해 유효성 검사(dto 자체만으로는 안되고 class-validator, class-transformer 설치)
export class UpdateMovieDto extends PartialType(CreateMovieDto){}