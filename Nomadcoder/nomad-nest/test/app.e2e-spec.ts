import { Test, TestingModule } from '@nestjs/testing';
import { INestApplication, ValidationPipe } from '@nestjs/common';
import * as request from 'supertest';
import { AppModule } from './../src/app.module';

// e2e 테스트 할 때 실제 app 환경을 그대로 적용시켜줘야 함.
// 실제 app main.ts의 pipe에는 transform을 적용되어 있어서 id를 number로 받을 수 있는데
// e2e 테스트 app에서는 transform 설정을 안해주면 id를 string으로 받아옴.
describe('AppController (e2e)', () => {
  let app: INestApplication;

  // beforeEach로 할 경우 describe 할 때마다 새로운 app이 만들어져 data가 연동되지 않음.
  beforeAll(async () => {
    const moduleFixture: TestingModule = await Test.createTestingModule({
      imports: [AppModule],
    }).compile();

    app = moduleFixture.createNestApplication();
    app.useGlobalPipes(
      new ValidationPipe({
        whitelist:true,
        forbidNonWhitelisted:true,
        transform:true,
      })
    );
    await app.init();
  });

  it('/ (GET)', () => {
    return request(app.getHttpServer())
      .get('/')
      .expect(200)
      .expect('Welcome to API');
  });

  describe('/movies', () => {
    it("GET", () => {
      return request(app.getHttpServer())
        .get('/movies')
        .expect(200)
        .expect([]);
    });

    it("POST 201", () => {
      return request(app.getHttpServer())
        .post('/movies')
        .send({
          title: 'Test',
          year: 2024,
          genres: ['test'],
        })
        .expect(201);
    });
    it("POST 400", () => {
      return request(app.getHttpServer())
        .post('/movies')
        .send({
          title: 'Test',
          year: 2024,
          genres: ['test'],
          other: 'thing'
        })
        .expect(400);
    });

    it("DELETE", () => {
      return request(app.getHttpServer())
        .delete('/movies')
        .expect(404);
    });
  });

  describe('/movies/:id', () => {
    it('GET 200', () => {
      return request(app.getHttpServer())
        .get('/movies/1')
        .expect(200);
    });
    it('GET 404', () => {
      return request(app.getHttpServer())
        .get('/movies/999')
        .expect(404);
    });

    // 초안 작성으로 it.todo 사용
    //it.todo('DELETE');
    //it.todo('PATCH');
    it('PATCH 200', () => {
      return request(app.getHttpServer())
        .patch('/movies/1')
        .send({title: 'Update Test'})
        .expect(200);
    });
    it('PATCH 404', () => {
      return request(app.getHttpServer())
        .patch('/movies/999')
        .send({title: 'Update Test'})
        .expect(404);
    });

    it('DELETE 200', () => {
      return request(app.getHttpServer())
        .delete('/movies/1')
        .expect(200);
    });
    it('DELETE 404', () => {
      return request(app.getHttpServer())
        .delete('/movies/999')
        .expect(404);
    });
  });
});
