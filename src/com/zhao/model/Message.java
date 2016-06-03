package com.zhao.model;

public class Message {

	private String header;
	private String content;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [header=" + header + ", content=" + content + "]";
	}

	public interface Builder {
		Builder buildHeader(String header);

		Builder buildContent(String message);

		Builder buildHeader();

		Builder buildContent();

		void send();
	}

	public static abstract class AbstractMessageBuilder implements Builder {
		Message message;

		public AbstractMessageBuilder() {
			message = new Message();
		}
	}

	public static class MessageBuilder extends AbstractMessageBuilder {

		@Override
		public Builder buildHeader() {
			// TODO Auto-generated method stub
			this.message.setHeader("empty header");
			return this;
		}

		@Override
		public Builder buildContent() {
			// TODO Auto-generated method stub
			this.message.setContent("empty content");
			return this;
		}

		@Override
		public Builder buildHeader(String header) {
			// TODO Auto-generated method stub
			this.message.setHeader(header);
			return this;
		}

		@Override
		public Builder buildContent(String message) {
			// TODO Auto-generated method stub
			this.message.setContent(message);
			return this;
		}

		@Override
		public void send() {
			// TODO Auto-generated method stub
			System.out.println(this.message.toString());
		}
	}

	public static class NoHeaderMessageBuilder extends AbstractMessageBuilder {

		@Override
		public Builder buildHeader() {
			// TODO Auto-generated method stub
			return this;
		}

		@Override
		public Builder buildContent() {
			// TODO Auto-generated method stub
			this.message.setContent("empty content");
			return this;
		}

		@Override
		public Builder buildHeader(String header) {
			// TODO Auto-generated method stub
			return this;
		}

		@Override
		public Builder buildContent(String message) {
			// TODO Auto-generated method stub
			this.message.setContent(message);
			return this;
		}

		@Override
		public void send() {
			// TODO Auto-generated method stub
			System.out.println(this.message.content);
		}
	}

	public static Builder Builder() {
		return new MessageBuilder().buildHeader().buildContent();
	}

	public static Builder Builder(Builder builder) {
		return builder.buildHeader().buildContent();
	}

}
