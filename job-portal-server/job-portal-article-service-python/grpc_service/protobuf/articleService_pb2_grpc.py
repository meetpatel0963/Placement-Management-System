# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

from . import articleService_pb2 as articleService__pb2


class CommentServiceStub(object):
    """Missing associated documentation comment in .proto file."""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.getAllComments = channel.unary_unary(
                '/CommentService/getAllComments',
                request_serializer=articleService__pb2.GetAllCommentsRequest.SerializeToString,
                response_deserializer=articleService__pb2.GetAllCommentsResponse.FromString,
                )
        self.getCommentById = channel.unary_unary(
                '/CommentService/getCommentById',
                request_serializer=articleService__pb2.GetCommentByIdRequest.SerializeToString,
                response_deserializer=articleService__pb2.GetCommentByIdResponse.FromString,
                )
        self.saveComment = channel.unary_unary(
                '/CommentService/saveComment',
                request_serializer=articleService__pb2.SaveCommentRequest.SerializeToString,
                response_deserializer=articleService__pb2.SaveCommentResponse.FromString,
                )
        self.updateComment = channel.unary_unary(
                '/CommentService/updateComment',
                request_serializer=articleService__pb2.UpdateCommentRequest.SerializeToString,
                response_deserializer=articleService__pb2.UpdateCommentResponse.FromString,
                )
        self.deleteComment = channel.unary_unary(
                '/CommentService/deleteComment',
                request_serializer=articleService__pb2.DeleteCommentRequest.SerializeToString,
                response_deserializer=articleService__pb2.DeleteCommentResponse.FromString,
                )
        self.getAllCommentsByArticleId = channel.unary_unary(
                '/CommentService/getAllCommentsByArticleId',
                request_serializer=articleService__pb2.GetAllCommentsByArticleIdRequest.SerializeToString,
                response_deserializer=articleService__pb2.GetAllCommentsByArticleIdResponse.FromString,
                )


class CommentServiceServicer(object):
    """Missing associated documentation comment in .proto file."""

    def getAllComments(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def getCommentById(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def saveComment(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def updateComment(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def deleteComment(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def getAllCommentsByArticleId(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_CommentServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'getAllComments': grpc.unary_unary_rpc_method_handler(
                    servicer.getAllComments,
                    request_deserializer=articleService__pb2.GetAllCommentsRequest.FromString,
                    response_serializer=articleService__pb2.GetAllCommentsResponse.SerializeToString,
            ),
            'getCommentById': grpc.unary_unary_rpc_method_handler(
                    servicer.getCommentById,
                    request_deserializer=articleService__pb2.GetCommentByIdRequest.FromString,
                    response_serializer=articleService__pb2.GetCommentByIdResponse.SerializeToString,
            ),
            'saveComment': grpc.unary_unary_rpc_method_handler(
                    servicer.saveComment,
                    request_deserializer=articleService__pb2.SaveCommentRequest.FromString,
                    response_serializer=articleService__pb2.SaveCommentResponse.SerializeToString,
            ),
            'updateComment': grpc.unary_unary_rpc_method_handler(
                    servicer.updateComment,
                    request_deserializer=articleService__pb2.UpdateCommentRequest.FromString,
                    response_serializer=articleService__pb2.UpdateCommentResponse.SerializeToString,
            ),
            'deleteComment': grpc.unary_unary_rpc_method_handler(
                    servicer.deleteComment,
                    request_deserializer=articleService__pb2.DeleteCommentRequest.FromString,
                    response_serializer=articleService__pb2.DeleteCommentResponse.SerializeToString,
            ),
            'getAllCommentsByArticleId': grpc.unary_unary_rpc_method_handler(
                    servicer.getAllCommentsByArticleId,
                    request_deserializer=articleService__pb2.GetAllCommentsByArticleIdRequest.FromString,
                    response_serializer=articleService__pb2.GetAllCommentsByArticleIdResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'CommentService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class CommentService(object):
    """Missing associated documentation comment in .proto file."""

    @staticmethod
    def getAllComments(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/CommentService/getAllComments',
            articleService__pb2.GetAllCommentsRequest.SerializeToString,
            articleService__pb2.GetAllCommentsResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def getCommentById(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/CommentService/getCommentById',
            articleService__pb2.GetCommentByIdRequest.SerializeToString,
            articleService__pb2.GetCommentByIdResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def saveComment(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/CommentService/saveComment',
            articleService__pb2.SaveCommentRequest.SerializeToString,
            articleService__pb2.SaveCommentResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def updateComment(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/CommentService/updateComment',
            articleService__pb2.UpdateCommentRequest.SerializeToString,
            articleService__pb2.UpdateCommentResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def deleteComment(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/CommentService/deleteComment',
            articleService__pb2.DeleteCommentRequest.SerializeToString,
            articleService__pb2.DeleteCommentResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def getAllCommentsByArticleId(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/CommentService/getAllCommentsByArticleId',
            articleService__pb2.GetAllCommentsByArticleIdRequest.SerializeToString,
            articleService__pb2.GetAllCommentsByArticleIdResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)


class ArticleServiceStub(object):
    """Articles

    """

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.getAllArticles = channel.unary_unary(
                '/ArticleService/getAllArticles',
                request_serializer=articleService__pb2.GetAllArticlesRequest.SerializeToString,
                response_deserializer=articleService__pb2.GetAllArticlesResponse.FromString,
                )
        self.getArticleById = channel.unary_unary(
                '/ArticleService/getArticleById',
                request_serializer=articleService__pb2.GetArticleByIdRequest.SerializeToString,
                response_deserializer=articleService__pb2.GetArticleByIdResponse.FromString,
                )
        self.saveArticle = channel.unary_unary(
                '/ArticleService/saveArticle',
                request_serializer=articleService__pb2.SaveArticleRequest.SerializeToString,
                response_deserializer=articleService__pb2.SaveArticleResponse.FromString,
                )
        self.updateArticle = channel.unary_unary(
                '/ArticleService/updateArticle',
                request_serializer=articleService__pb2.UpdateArticleRequest.SerializeToString,
                response_deserializer=articleService__pb2.UpdateArticleResponse.FromString,
                )
        self.deleteArticle = channel.unary_unary(
                '/ArticleService/deleteArticle',
                request_serializer=articleService__pb2.DeleteArticleRequest.SerializeToString,
                response_deserializer=articleService__pb2.DeleteArticleResponse.FromString,
                )


class ArticleServiceServicer(object):
    """Articles

    """

    def getAllArticles(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def getArticleById(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def saveArticle(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def updateArticle(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def deleteArticle(self, request, context):
        """Missing associated documentation comment in .proto file."""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_ArticleServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'getAllArticles': grpc.unary_unary_rpc_method_handler(
                    servicer.getAllArticles,
                    request_deserializer=articleService__pb2.GetAllArticlesRequest.FromString,
                    response_serializer=articleService__pb2.GetAllArticlesResponse.SerializeToString,
            ),
            'getArticleById': grpc.unary_unary_rpc_method_handler(
                    servicer.getArticleById,
                    request_deserializer=articleService__pb2.GetArticleByIdRequest.FromString,
                    response_serializer=articleService__pb2.GetArticleByIdResponse.SerializeToString,
            ),
            'saveArticle': grpc.unary_unary_rpc_method_handler(
                    servicer.saveArticle,
                    request_deserializer=articleService__pb2.SaveArticleRequest.FromString,
                    response_serializer=articleService__pb2.SaveArticleResponse.SerializeToString,
            ),
            'updateArticle': grpc.unary_unary_rpc_method_handler(
                    servicer.updateArticle,
                    request_deserializer=articleService__pb2.UpdateArticleRequest.FromString,
                    response_serializer=articleService__pb2.UpdateArticleResponse.SerializeToString,
            ),
            'deleteArticle': grpc.unary_unary_rpc_method_handler(
                    servicer.deleteArticle,
                    request_deserializer=articleService__pb2.DeleteArticleRequest.FromString,
                    response_serializer=articleService__pb2.DeleteArticleResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'ArticleService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class ArticleService(object):
    """Articles

    """

    @staticmethod
    def getAllArticles(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/ArticleService/getAllArticles',
            articleService__pb2.GetAllArticlesRequest.SerializeToString,
            articleService__pb2.GetAllArticlesResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def getArticleById(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/ArticleService/getArticleById',
            articleService__pb2.GetArticleByIdRequest.SerializeToString,
            articleService__pb2.GetArticleByIdResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def saveArticle(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/ArticleService/saveArticle',
            articleService__pb2.SaveArticleRequest.SerializeToString,
            articleService__pb2.SaveArticleResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def updateArticle(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/ArticleService/updateArticle',
            articleService__pb2.UpdateArticleRequest.SerializeToString,
            articleService__pb2.UpdateArticleResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def deleteArticle(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/ArticleService/deleteArticle',
            articleService__pb2.DeleteArticleRequest.SerializeToString,
            articleService__pb2.DeleteArticleResponse.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
