package com.example.sweetsystem.AcceptanceTest;

import com.example.sweetsystem.clasess.Message;
import com.example.sweetsystem.clasess.OwnerAndSupplier;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Tag;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Tag("tag2")
public class SendMessageSteps {
    private OwnerAndSupplier sender;
    private OwnerAndSupplier receiver;
    private String errorMessage;

    @Given("a user with ID {int} exists and a receiver with ID {int} exists and the receiver is an owner or supplier")
    public void a_user_with_id_exists_and_a_receiver_with_id_exists_and_the_receiver_is_an_owner_or_supplier(int senderId, int receiverId) {
        sender = OwnerAndSupplier.getOwnerSupplier(senderId);
        receiver = OwnerAndSupplier.getOwnerSupplier(receiverId);
    }

    @When("the user sends a message {string} to receiver with ID {int}")
    public void the_user_sends_a_message_to_receiver_with_id(String content, int id) {
        errorMessage = sender.sendMessage(content, id);
    }

    @Then("the message {string} should be added to the user's sent messages and the message should be received by the receiver and successful operation message is shown")
    public void the_message_should_be_added_to_the_user_s_sent_messages_and_the_message_should_be_received_by_the_receiver_and_successful_operation_message_is_shown(String hello) {
        List<String> sentMessageContents = new ArrayList<>();
        for (Message m : sender.getSentMessages()) {
            sentMessageContents.add(m.getContent());
        }

        List<String> unreadMessageContents = new ArrayList<>();
        for (Message m : receiver.getUnreadMessages()) {
            unreadMessageContents.add(m.getContent());
        }
        assertEquals(List.of(hello), sentMessageContents);
        assertEquals(List.of(hello), unreadMessageContents);
        Assert.assertEquals(OwnerAndSupplier.SUCCESSFUL_OPERATION, errorMessage);
    }

    @Given("a user with ID {int} exists and a receiver with ID {int} does not exist")
    public void a_user_with_id_exists_and_a_receiver_with_id_does_not_exist(int senderID, int receiverID) {
        sender = OwnerAndSupplier.getOwnerSupplier(senderID);
        receiver = OwnerAndSupplier.getOwnerSupplier(receiverID);
    }

    @When("the user send a message {string} to receiver with ID {int}")
    public void the_user_send_a_message_to_receiver_with_id(String content, int ID) {
        errorMessage = sender.sendMessage(content, ID);
    }

    @Then("receiver does not exist message is shown")
    public void receiver_does_not_exist_message_is_shown() {
        Assert.assertEquals(OwnerAndSupplier.RECEIVER_DOESNT_EXIST, errorMessage);
    }
}
