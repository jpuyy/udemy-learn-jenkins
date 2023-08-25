FROM jenkins/jenkins

USER root

RUN apt update && apt install -y python3 python3-distutils && \
curl -O https://bootstrap.pypa.io/get-pip.py && \
python3 get-pip.py && pip3 install ansible --upgrade

USER jenkins