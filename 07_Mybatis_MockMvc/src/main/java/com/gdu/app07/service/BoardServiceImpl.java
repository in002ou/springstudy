package com.gdu.app07.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.app07.domain.BoardDTO;
import com.gdu.app07.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public List<BoardDTO> getBoardList() {
		return boardDAO.selectBoardList();
	}

	@Override
	public BoardDTO getBoardByNo(HttpServletRequest request) {
		// 파라미터 boardNo가 없으면(null, "") 0을 사용한다.	Optional은 빈문자열을 처리 못한다.
		String strBoardNo = request.getParameter("boardNo");
		int boardNo = 0;
		if(strBoardNo != null && strBoardNo.isEmpty() == false) {
			boardNo = Integer.parseInt(strBoardNo);
		}
		return boardDAO.selectBoardByNo(boardNo);
	}

	@Override
	public int addBoard(HttpServletRequest request) {
		try {
			// 파리미터 title, content, writer를 받아온다.
			BoardDTO board = new BoardDTO();
			board.setTitle(request.getParameter("title"));
			board.setContent(request.getParameter("content"));
			board.setWriter(request.getParameter("writer"));
			return boardDAO.insertBoard(board);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int modifyBoard(HttpServletRequest request) {
		try {
			// 파라미터 title, content, boardNo(null, "" 처리를 하지 않는다.
			// post요청임으로 주소창으로 값을 비워 보내지도 직접 적어 보낼 수 없기 때문 값이 안온다면 개발자 잘못)
			BoardDTO board = new BoardDTO();
			board.setTitle(request.getParameter("title"));
			board.setContent(request.getParameter("content"));
			board.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
			return boardDAO.updateBoard(board);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int removeBoard(HttpServletRequest request) {
		try {
			return boardDAO.deleteBoard(Integer.parseInt(request.getParameter("boardNo")));
		} catch (Exception e) {
			return 0;
		}
	}

	// 트랜잭션 확인 (insert, update, delete를 두 개 이상 사용할 때 정상 동작 확인)
	@Transactional
	@Override
	public void testTx() {
		boardDAO.insertBoard(new BoardDTO(0, "타이틀", "콘텐트", "작성자", null, null));
		boardDAO.insertBoard(new BoardDTO());
	}
	
}
