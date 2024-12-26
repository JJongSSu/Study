import { IsNumber, IsOptional, IsString } from "class-validator";

// code 간결성, 쿼리에 대해 유효성 검사(dto 자체만으로는 안되고 class-validator, class-transformer 설치)
export class CreateMovieDto{
    @IsString()
    readonly title: string;

    @IsNumber()
    readonly year: number;

    @IsOptional()
    @IsString({each:true})
    readonly genres: string[];
}