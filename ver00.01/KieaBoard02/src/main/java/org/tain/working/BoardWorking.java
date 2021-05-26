package org.tain.working;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tain.domain.board.Board;
import org.tain.repository.board.BoardRepository;
import org.tain.utils.CurrentInfo;
import org.tain.utils.Flag;
import org.tain.utils.JsonPrint;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BoardWorking {

	@Autowired
	private BoardRepository boardRepository;
	
	// public void loading() {
	public void load() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			IntStream.rangeClosed(1, 200).forEach(index -> {
				this.boardRepository.save(Board.builder()
						.title("제목-" + index)
						.subTitle("부제목-" + index)
						.content("안녕하세요.\n내용입니다. 감사합니다.")
						//.userName("kiea")
						.userName("Yewon")
						.build());
			});
		}
	}
	
	//public void selecting() {
	public void select() {
		log.info("KANG-20200803 >>>>> {} {}", CurrentInfo.get());
		
		if (Flag.flag) {
			this.boardRepository.findAll().forEach(entity -> {
				log.info(">>>>> json: {}", JsonPrint.getInstance().toPrettyJson(entity));
			});
		}
	}
}
