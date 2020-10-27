package main;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArticleDao dao = new ArticleDao();

		while (true) {
			System.out.print("명령어 입력 : ");
			String cmd = sc.next();
			if (cmd.equals("exit")) {
				System.out.println("종료");
				break;
			}
			if (cmd.equals("add")) {

				Article a = new Article();

				System.out.println("게시물 제목을 입력해주세요 :");
				String title = sc.next();
				a.setTitle(title);

				System.out.println("게시물 내용을 입력해주세요 :");
				String body = sc.next();
				a.setBody(body);
				a.setNickname("익명");

				dao.insertArticle(a);
				System.out.println("게시물이 등록되었습니다.");

			}
			if (cmd.equals("list")) {
				ArrayList<Article> articles = dao.getArticles();

				printArticles(articles);

			}
			if (cmd.equals("update")) {

				System.out.println("수정할 게시물 선택 : ");
				int targetId = sc.nextInt();
				Article target = dao.getArticleById(targetId);
				if (target == null) {
					System.out.println("없는 게시물입니다.");
				} else {
					System.out.println("게시물 제목을 입력해주세요 :");
					String newTitle = sc.next();

					System.out.println("게시물 내용을 입력해주세요 :");
					String newBody = sc.next();

					target.setTitle(newTitle);
					target.setBody(newBody);

					break;
				}
			}
			if (cmd.equals("delete")) {
				ArrayList<Article> articles = dao.getArticles();
				System.out.println("삭제할 게시물 선택 : ");
				int targetId = sc.nextInt();
				Article target = dao.getArticleById(targetId);
				if (target == null) {
					System.out.println("게시물이 존재하지 않습니다.");
				} else {
					dao.removeArticle(target);
				}
			}
			if (cmd.equals("read")) {
				System.out.println("상세보기할 게시물 선택 : ");
				int targetId = sc.nextInt();
				Article target = dao.getArticleById(targetId);
				ArrayList<Comment> comments = dao.getComments();
				if (target == null) {
					System.out.println("게시물이 존재하지 않습니다.");
				} else {
					target.setHit(target.getHit() + 1);
					System.out.println("==== " + target.getId() + " ====");
					System.out.println("번호 : " + target.getId());
					System.out.println("제목 : " + target.getTitle());
					System.out.println("내용 : " + target.getBody());
					System.out.println("===============");
					printComments(comments);

					while (true) {
						System.out.println("상세보기 기능을 선택해주세요");
						System.out.println("1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로 : ");
						int readCmd = sc.nextInt();
						if (readCmd == 1) {
							System.out.println("[댓글 기능]");
							Comment a = new Comment();

							System.out.println("댓글 내용을 입력해주세요: ");
							String commentbody = sc.next();
							a.setComment(commentbody);

							dao.insertComment(a);
							System.out.println("댓글이 등록되었습니다.");

							System.out.println("==== " + target.getId() + " ====");
							System.out.println("번호 : " + target.getId());
							System.out.println("제목 : " + target.getTitle());
							System.out.println("내용 : " + target.getBody());
							System.out.println("작성일 : " + target.getRegDate());
							System.out.println("작성자 : " + target.getNickname());
							System.out.println("===============");
							

							System.out.println("-----댓글-----");
							printComments(comments);

						} else if (readCmd == 2) {
							System.out.println("[좋아요 기능]");
						} else if (readCmd == 3) {
							System.out.println("[수정 기능]");

							System.out.println("게시물 제목을 입력해주세요 :");
							String newTitle = sc.next();
							System.out.println("게시물 내용을 입력해주세요 :");
							String newBody = sc.next();
							target.setTitle(newTitle);
							target.setBody(newBody);
						} else if (readCmd == 4) {
							System.out.println("[삭제 기능]");

							dao.removeArticle(target);
						} else if (readCmd == 5) {
							System.out.println("[목록으로]");
							break;
						}
					}
				}
			}
			
			if (cmd.equals("search")) {
				System.out.println("검색 항목을 입력해주세요. ");
				System.out.println("1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자 : ");
				int flag = sc.nextInt();
				System.out.println("검색 키워드를 입력해주세요 : ");
				String keyword = sc.next();
				ArrayList<Article> searchedArticles;

				searchedArticles = dao.getSearchedArticlesByFlag(flag, keyword);

				printArticles(searchedArticles);
			}
		}
	}

	private static void printArticles(ArrayList<Article> articleList) {
		for (int i = 0; i < articleList.size(); i++) {
			Article article = articleList.get(i);
			System.out.println("번호 : " + article.getId());
			System.out.println("제목 : " + article.getTitle());
			System.out.println("등록날짜 : " + article.getRegDate());
			System.out.println("작성자 : " + article.getNickname());
			System.out.println("조회수 : " + article.getHit());
			System.out.println("===================");
		}
	}

	private static void printComments(ArrayList<Comment> commentList) {
		for (int i = 0; i < commentList.size(); i++) {
			Comment comment = commentList.get(i);
			System.out.println("내용 : " + comment.getComment());
			System.out.println("작성자 : " + comment.getNickname());
			System.out.println("작성일 : " + comment.getRegDate());
			System.out.println("===================");
		}
	}

}
