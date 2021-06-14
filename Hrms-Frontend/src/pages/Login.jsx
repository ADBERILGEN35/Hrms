import React from "react";
import { Link } from "react-router-dom";
import { Button, Form, Header, Image, Message, Segment } from 'semantic-ui-react'

export default function Login() {
    return (
        <div>
            <Header as="h2" color="teal" textAlign="center">
                <Image src="https://lh3.googleusercontent.com/proxy/cLM5Ijd1idMjb3x8ogRArQ0b-gMw2iW3K-a0OAy2ijfkKeAA0qHgtCyXuiEMVuJBNgXvs9ciZXbG4-pg51TOrpPP963DUR74QJJtn26Md55MU1t7ng" /> Giriş Yap
            </Header>
            <Form size="large">
                <Segment stacked>
                    <Form.Input
                        fluid
                        icon="user"
                        iconPosition="left"
                        placeholder="E-mail adresi"
                    />
                    <Form.Input
                        fluid
                        icon="lock"
                        iconPosition="left"
                        placeholder="Şifre"
                        type="password"
                    />

                    <Button color="teal" fluid size="large" disabled>
                        Giriş Yap
                    </Button>
                </Segment>
            </Form>
            <Message>
                 <Link to={"/register"}> Kayıt Olmak İçin Tıklayınız.</Link>
            </Message>
        </div>
    );
}
