FROM jenkins/jenkins:2.416

USER root

# ansible
RUN apt update && apt install -y python3 python3-distutils && \
curl -O https://bootstrap.pypa.io/get-pip.py && \
python3 get-pip.py && pip3 install ansible --upgrade

# docker client
RUN apt install ca-certificates curl gnupg -y && \
install -m 0755 -d /etc/apt/keyrings && \
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | gpg --dearmor -o /etc/apt/keyrings/docker.gpg && \
chmod a+r /etc/apt/keyrings/docker.gpg

# for docker keyrings
RUN export VERSION_CODENAME=$(. /etc/os-release && echo "$VERSION_CODENAME") && export ARCH=$(dpkg --print-architecture) && echo "deb [arch=${ARCH} signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu ${VERSION_CODENAME} stable" > /etc/apt/sources.list.d/docker.list

# 
RUN apt update && apt install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin -y

USER jenkins
