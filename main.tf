resource "aws_instance" "sarpio-server" {
    ami = "ami-0faab6bdbac9486fb"
    instance_type = "t2.micro"
    tags = {
      Name = "shopping-server"
    }
    security_groups = "sg-0dbaaca02d6b8b06a"
    subnet_id = "subnet-0badc243b17ab0695"
    vpc_security_group_ids = "vpc-0aafe8f06ff612ce7"
}